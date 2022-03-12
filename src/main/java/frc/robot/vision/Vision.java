package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.Turret;
import frc.robot.yawControl.YawControl;
import vision.limelight.Limelight;
import vision.limelight.enums.LimelightLedMode;
import vision.limelight.target.LimelightTarget;

import static frc.robot.Constants.*;
import static frc.robot.vision.VisionConstants.*;

public class Vision extends SubsystemBase {

    private final Limelight limelight;
    private final VisionShuffleboard visionShuffleboard;
    private final DriveTrain driveTrain;
    private LimelightTarget limelightTarget;
    private Vector2dEx turretToTargetVectorRTT;

    public Vision(DriveTrain driveTrain) {
        limelight = Limelight.getInstance();
        this.driveTrain = driveTrain;
        visionShuffleboard = new VisionShuffleboard(this);
        visionShuffleboard.init();
        limelight.setPipeline(PIPELINE);
        limelight.setLedMode(LimelightLedMode.forceOn);
    }

    public void setPipeline(int pipeline){
        limelight.setPipeline(pipeline);
        limelight.setLedMode(LimelightLedMode.forceOn);
    }

    @Override
    public void periodic() {
        limelightTarget = limelight.getTarget();
        visionShuffleboard.periodic();
        updateTurretToTargetVectorRTT();
    }

    private double getDistanceLimelightFromTarget() {
        if (hasTarget()) {
            double verticalAngleLimelightToTarget = limelightTarget.getVerticalOffsetToCrosshair();
            double verticalAngleRobotToTarget = LIMELIGHT_ANGLE_TO_HORIZON_DEG + verticalAngleLimelightToTarget;
            return LIMELIGHT_TO_TARGET_CM / Math.tan(Math.toRadians(verticalAngleRobotToTarget));
        }
        return TARGET_NOT_FOUND;
    }

    private void updateTurretToTargetVectorRTT() {
        if (hasTarget()) {
            double limelightOffsetFromTarget = limelightTarget.getHorizontalOffsetToCrosshair();
            turretToTargetVectorRTT = Vector2dEx.fromMagnitudeDirection(getDistanceLimelightFromTarget(),
                    limelightOffsetFromTarget);
            turretToTargetVectorRTT.subtract(LIMELIGHT_TO_TURRET_VECTOR_RTT);
        } else {
            turretToTargetVectorRTT = null;
        }
    }

    public double getHorizontalAngleTurretToTargetRTT() {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.direction();
        return TARGET_NOT_FOUND;
    }

    public double getHorizontalAngleTurretToTargetRTR(Turret turret) {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.direction() + turret.getCurrentAngleRTR();
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

    /*
    public double getRobotToTargetAngleRTF() {
        if (turretToTargetVectorRTT != null) {
            return getHorizontalAngleTurretToTargetRTT() + yawControl.getTurretAngleRTF();
        }
        return TARGET_NOT_FOUND;
    }
    */

    public Translation2d getXAndY() {
        double robotToTargetAngleRTF = driveTrain.getHeading();
        double x = TARGET_POSE_X - Math.cos(Math.toRadians(robotToTargetAngleRTF));
        double y = TARGET_POSE_Y - Math.sin(Math.toRadians(robotToTargetAngleRTF));
        return new Translation2d(x, y);
    }

    public Translation2d getXAndYAuto() {
        if (hasTarget()) {
            if (Math.abs(getHorizontalAngleTurretToTargetRTT()) < TURRET_TOLERANCE) {
                return getXAndY();
            }
        }
        return new Translation2d(TARGET_NOT_FOUND, TARGET_NOT_FOUND);
    }

    public void ledsOff() {
        limelight.setLedMode(LimelightLedMode.forceOff);
    }

    public void ledsOn() {
        limelight.setLedMode(LimelightLedMode.forceOn);
    }

    public DriveTrain getDriveTrain() {
        return driveTrain;
    }
}
