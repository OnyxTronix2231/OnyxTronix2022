package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.turret.Turret;
import frc.robot.yawControl.YawControl;
import vision.limelight.Limelight;
import vision.limelight.enums.LimelightLedMode;
import vision.limelight.target.LimelightTarget;

import static frc.robot.Constants.*;
import static frc.robot.vision.VisionConstants.*;

public class Vision extends SubsystemBase {

    private final Limelight limelight;
    private LimelightTarget limelightTarget;
    private Vector2dEx turretToTargetVectorRTT;
    private static Vision instance;

    private double middleTargetY;
    private double normalizedMiddleTargetY;
    private double pixelMiddleTargetY;

    private double pixelTopTargetY;

    private double normalizedTopTargetY;

    public double getMiddleTargetY() {
        return middleTargetY;
    }

    public double getNormalizedMiddleTargetY() {
        return normalizedMiddleTargetY;
    }

    public double getPixelMiddleTargetY() {
        return pixelMiddleTargetY;
    }

    public double getPixelTopTargetY() {
        return pixelTopTargetY;
    }

    public double getNormalizedTopTargetY() {
        return normalizedTopTargetY;
    }

    public double getTopTargetY() {
        return topTargetY;
    }

    private double topTargetY;

    private Vision() {
        limelight = Limelight.getInstance();
        VisionShuffleboard visionShuffleboard = new VisionShuffleboard(this);
        visionShuffleboard.init();
        limelight.setPipeline(PIPELINE);
    }

    public static Vision getInstance() {
        if (instance == null) {
            instance = new Vision();
        }
        return instance;
    }

    public void setPipeline(int pipeline) {
        limelight.setPipeline(pipeline);
        limelight.setLedMode(LimelightLedMode.forceOn);
    }

    public void setLedMode(LimelightLedMode limelightLedMode) {
        limelight.setLedMode(limelightLedMode);
    }

    @Override
    public void periodic() {
        limelightTarget = limelight.getTarget();
        updateTurretToTargetVectorRTT();
    }

    private double getDistanceLimelightFromTarget() {
        LimelightTarget tempLimelightTarget = limelightTarget;
        if (tempLimelightTarget != null) {
            double verticalAngleLimelightToTarget = getVerticalAngleOffset();
            double verticalAngleRobotToTarget = LIMELIGHT_ANGLE_TO_HORIZON_DEG + verticalAngleLimelightToTarget;
            return LIMELIGHT_TO_TARGET_CM / Math.tan(Math.toRadians(verticalAngleRobotToTarget));
        }
        return TARGET_NOT_FOUND;
    }

    private void updateTurretToTargetVectorRTT() {
        LimelightTarget tempLimelightTarget = limelightTarget;
        if (tempLimelightTarget != null) {
            double limelightOffsetFromTarget = tempLimelightTarget.getHorizontalOffsetToCrosshair();
            double limelightDistanceFromTarget = getDistanceLimelightFromTarget();
            if (limelightDistanceFromTarget != TARGET_NOT_FOUND) {
                turretToTargetVectorRTT = Vector2dEx.fromMagnitudeDirection(limelightDistanceFromTarget,
                        limelightOffsetFromTarget);
                turretToTargetVectorRTT.subtract(LIMELIGHT_TO_TURRET_VECTOR_RTT);
            }
        } else {
            turretToTargetVectorRTT = null;
        }
    }

    public double getHorizontalAngleTurretToTargetRTT() {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.direction();
        return TARGET_NOT_FOUND;
    }

    public double getHorizontalDistanceTurretToTarget() {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.magnitude() + TARGET_RADIUS;
        return TARGET_NOT_FOUND;
    }

    public boolean hasTarget() {
        return limelight.targetFound();
    }

    public double getRobotToTargetAngleRTF(YawControl yawControl) {
        if (turretToTargetVectorRTT != null) {
            return -getHorizontalAngleTurretToTargetRTT() + yawControl.getTurretAngleRTF();
        }
        return TARGET_NOT_FOUND;
    }

    public Translation2d getXAndY(YawControl yawControl) {
        double robotToTargetAngleRTF = getRobotToTargetAngleRTF(yawControl);
        double distance = getHorizontalDistanceTurretToTarget() / CM_IN_METER;
        double x = TARGET_POSE_X + Math.cos(Math.toRadians(robotToTargetAngleRTF)) * distance;
        double y = TARGET_POSE_Y + Math.sin(Math.toRadians(robotToTargetAngleRTF)) * distance;
        return new Translation2d(x, y);
    }

    public Translation2d getXAndYAuto(YawControl yawControl) {
        if (hasTarget()) {
            return getXAndY(yawControl);
        }
        return DEFAULT_POSE;
    }

    public double getVerticalAngleOffset() {
        if (limelight.targetFound()) {
            LimelightTarget target = limelight.getTarget();
            middleTargetY = Math.tan(Math.toRadians(target.getVerticalOffsetToCrosshair()));
            normalizedMiddleTargetY = (2 * middleTargetY) / VPH;
            pixelMiddleTargetY = (SCREEN_HEIGHT / 2) - (normalizedMiddleTargetY * (SCREEN_HEIGHT / 2));

            pixelTopTargetY = pixelMiddleTargetY - (target.getShortSideOfFittedBoundingBox() / 2);

            normalizedTopTargetY = ((SCREEN_HEIGHT / 2) - 0.5 - pixelTopTargetY) / ((SCREEN_HEIGHT / 2));
            topTargetY = (VPH / 2) * normalizedTopTargetY;

            return Math.toDegrees(Math.atan(topTargetY));
        }
        return -999;
    }

    public void ledsOff() {
        limelight.setLedMode(LimelightLedMode.forceOff);
    }

    public void ledsOn() {
        limelight.setLedMode(LimelightLedMode.forceOn);
    }

    public double getLimelightVerticalAngle(){
        if (limelight.targetFound())
            return limelight.getTarget().getVerticalOffsetToCrosshair();
        return -999;
    }
}
