package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import vision.limelight.Limelight;
import vision.limelight.target.LimelightTarget;

import static frc.robot.Constants.TargetXRTF;
import static frc.robot.Constants.TargetYRTF;
import static frc.robot.vision.VisionConstants.*;


public class Vision {
    private final Limelight limelight;
    private LimelightTarget limelightTarget;
    private Vector2dEx turretToTargetVector;

    public Vision() {
        this.limelight = Limelight.getInstance();
    }

    private double getDistanceLimelightFromTarget() {
        if (limelight.targetFound()) {
            double verticalAngleLimelightToTarget = limelightTarget.getVerticalOffsetToCrosshair();
            double verticalAngleRobotToTarget = LIMELIGHT_ANGLE_TO_HORIZON_DEG + verticalAngleLimelightToTarget;
            return LIMELIGHT_TO_TARGET_CM / Math.tan(Math.toRadians(verticalAngleRobotToTarget));
        }
        return -999;
    }

    private void updateTurretToTargetVector() {
        if (limelight.targetFound()) {
            double limelightOffsetFromTarget = limelightTarget.getHorizontalOffsetToCrosshair();
            Vector2dEx limelightToTurret = Vector2dEx.fromMagnitudeDirection(LIMELIGHT_TO_TURRET_CM, 0);
            turretToTargetVector = Vector2dEx.fromMagnitudeDirection(getDistanceLimelightFromTarget(),
                    limelightOffsetFromTarget);
            turretToTargetVector.add(limelightToTurret);
        } else
            turretToTargetVector = null;
    }

    public double getHorizontalAngelTurretToTargetRTR() {
        if (turretToTargetVector != null)
            return turretToTargetVector.direction();
        return -999;
    }

    public double getHorizontalDistanceTurretToTarget() {
        if (turretToTargetVector != null)
            return turretToTargetVector.magnitude();
        return -999;
    }

    public void update() {
        this.limelightTarget = limelight.getTarget();
        updateTurretToTargetVector();
    }

    public boolean hasTarget() {
        return limelight.targetFound();
    }

    public double getRobotXByVision(){
        return MID_TARGET_X_RTF - getDistanceFromTarget() * Math.cos(Math.toRadians(TURRET_ANGLE_RTF));
    }

    public double getRobotYByVision(){
        return MID_TARGET_Y_RTF - getDistanceFromTarget() * Math.sin(Math.toRadians(TURRET_ANGLE_RTF));

    public double getRobotToTargetAngleRTF(Drivetrain drivetrain) {
        double horizontalAngelTurretToTargetRTR = getHorizontalAngelTurretToTargetRTR();
        return horizontalAngelTurretToTargetRTR + drivetrain.getHeading();
    }

    public Translation2d getXAndY(Drivetrain drivetrain) {
        double robotToTargetAngleRTF = getRobotToTargetAngleRTF(drivetrain);
        double x = TargetXRTF - Math.cos(Math.toRadians(robotToTargetAngleRTF));
        double y = TargetYRTF - Math.sin(Math.toRadians(robotToTargetAngleRTF));
        return new Translation2d(x, y);
    }
}