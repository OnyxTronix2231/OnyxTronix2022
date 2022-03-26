package frc.robot.crossPlatform.teleopCommands.OdometryUpdater;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import static frc.robot.crossPlatform.teleopCommands.OdometryUpdater.OdometryUpdaterConstants.FIXABLE_ANGLE_OFFSET;
import static frc.robot.crossPlatform.teleopCommands.OdometryUpdater.OdometryUpdaterConstants.ODOMETRY_UPDATE_PERIOD;

public class UpdateOdometryByVision {

    private final DriveTrain driveTrain;
    private final YawControl yawControl;
    private double lastTime;

    public UpdateOdometryByVision(DriveTrain driveTrain, YawControl yawControl) {
        this.driveTrain = driveTrain;
        this.yawControl = yawControl;
        lastTime = Timer.getFPGATimestamp();
    }

    public void updateOdometry() {
        boolean shouldUpdate = Vision.getInstance().hasTarget();
        double currentTime = Timer.getFPGATimestamp();
        double dt = currentTime - lastTime;
        if (shouldUpdate) {
            if (dt > ODOMETRY_UPDATE_PERIOD && Math.abs(Vision.getInstance().getHorizontalAngleTurretToTargetRTT()) < FIXABLE_ANGLE_OFFSET) {
                lastTime = currentTime;
                Translation2d visionTrans = Vision.getInstance().getXAndYAuto(yawControl);
                Rotation2d robotRotation = driveTrain.getPose().getRotation();
                driveTrain.resetOdometryToPose(new Pose2d(visionTrans, robotRotation));
            }
        }
    }
}
