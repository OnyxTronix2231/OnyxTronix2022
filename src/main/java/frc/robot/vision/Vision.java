package frc.robot.vision;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import vision.limelight.Limelight;
import vision.limelight.target.LimelightTarget;

import java.util.function.DoubleSupplier;

import static frc.robot.vision.VisionConstants.LIMELIGHT_ANGLE_TO_HORIZON_DEG;
import static frc.robot.vision.VisionConstants.LIMELIGHT_TO_TARGET_CM;


public class Vision {
    private final Limelight limelight;
    private LimelightTarget limelightTarget;
    private DoubleSupplier horizontalAngle;
    private DoubleSupplier distance;

    public Vision() {
        this.limelight = Limelight.getInstance();
        Shuffleboard.getTab("Vision").addNumber("Horizontal Angle", horizontalAngle);
        Shuffleboard.getTab("Vision").addNumber("Distance", distance);
    }

    public double getDistanceFromTarget() {
        if (limelight.targetFound()) {
            double verticalAngleLimelightToTarget = limelightTarget.getVerticalOffsetToCrosshair();
            double verticalAngleRobotToTarget = LIMELIGHT_ANGLE_TO_HORIZON_DEG + verticalAngleLimelightToTarget;
            return LIMELIGHT_TO_TARGET_CM / Math.tan(Math.toRadians(verticalAngleRobotToTarget));
        }
        return -999;
    }

    public double getHorizontalAngelLimelightToTarget() {
        if (limelight.targetFound())
            return limelightTarget.getHorizontalOffsetToCrosshair();
        return -999;
    }

    public void update() {
        this.limelightTarget = limelight.getTarget();
        distance = this::getDistanceFromTarget;
        horizontalAngle = this::getHorizontalAngelLimelightToTarget;
    }

    public boolean hasTarget() {
        return limelight.targetFound();
    }
}