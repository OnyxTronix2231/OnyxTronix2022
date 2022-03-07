package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.turret.Turret;
import frc.robot.yawControl.YawControl;
import vision.limelight.Limelight;
import vision.limelight.target.LimelightTarget;

import static frc.robot.vision.VisionConstants.*;

public class Vision extends SubsystemBase {

    private final Limelight limelight;
    private final VisionShuffleboard visionShuffleboard;
    private LimelightTarget limelightTarget;
    private Vector2dEx turretToTargetVectorRTT;

    public Vision() {
        limelight = Limelight.getInstance();
        visionShuffleboard = new VisionShuffleboard(this);
        visionShuffleboard.init();
    }

    @Override
    public void periodic() {
        limelightTarget = limelight.getTarget();
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

    public double getRobotToTargetAngleRTF(YawControl yawControl) {
        if (turretToTargetVectorRTT != null) {
            return getHorizontalAngleTurretToTargetRTT() + yawControl.getTurretAngleRTF();
        }
        return TARGET_NOT_FOUND;
    }

    public Translation2d getXAndY(YawControl yawControl) {
        double robotToTargetAngleRTF = getRobotToTargetAngleRTF(yawControl);
        double x = TARGET_X_RTF - Math.cos(Math.toRadians(robotToTargetAngleRTF));
        double y = TARGET_Y_RTF - Math.sin(Math.toRadians(robotToTargetAngleRTF));
        return new Translation2d(x, y);
    }

    public Translation2d getXAndYAuto(YawControl yawControl) {
        if (hasTarget()) {
            if (Math.abs(getHorizontalAngleTurretToTargetRTT()) < TURRET_TOLERANCE) {
                return getXAndY(yawControl);
            }
        }
        return null;
    }
}
