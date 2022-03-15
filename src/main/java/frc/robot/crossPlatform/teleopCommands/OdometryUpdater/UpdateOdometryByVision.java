package frc.robot.crossPlatform.teleopCommands.OdometryUpdater;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import static frc.robot.crossPlatform.teleopCommands.OdometryUpdater.OdometryUpdaterConstants.FIXABLE_ANGLE_OFFSET;
import static frc.robot.crossPlatform.teleopCommands.OdometryUpdater.OdometryUpdaterConstants.ODO_UPDATE_PERIOD;

public class UpdateOdometryByVision {

    private static double lastTime;

    public UpdateOdometryByVision() {
        lastTime = Timer.getFPGATimestamp();
    }

    public static void updateOdometryByVision(DriveTrain driveTrain, YawControl yawControl, Vision vision) {
        boolean shouldUpdate = vision.hasTarget();
        double currentTime = Timer.getFPGATimestamp();
        double dt = currentTime - lastTime;
        if (shouldUpdate) {
            if (dt > ODO_UPDATE_PERIOD && Math.abs(vision.getHorizontalAngleTurretToTargetRTT()) < FIXABLE_ANGLE_OFFSET) {
                lastTime = currentTime;
                Translation2d visionTrans = vision.getXAndYAuto(yawControl);
                Rotation2d robotRotation = driveTrain.getPose().getRotation();
                driveTrain.resetOdometryToPose(new Pose2d(visionTrans, robotRotation));
            }
        }
    }
}
