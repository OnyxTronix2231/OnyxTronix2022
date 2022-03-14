package frc.robot.crossPlatform.teleopCommands.OdometryUpdater;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

public class UpdateFuncs {

    private static double lastTime;

    public UpdateFuncs() {
        lastTime = Timer.getFPGATimestamp();
    }

    public static void updateOdometryByVision(DriveTrain driveTrain, YawControl yawControl, Vision vision) {
        boolean shouldUpdate = vision.hasTarget();
        double currentTime = Timer.getFPGATimestamp();
        double dt = currentTime - lastTime;
        if (shouldUpdate) {
            if (dt > 0.3 && Math.abs(vision.getHorizontalAngleTurretToTargetRTT()) < 50) {
                System.out.println("update");
                lastTime = currentTime;
                Translation2d visionTrans = new Translation2d(vision.getXAndYAuto(yawControl).getX(), vision.getXAndYAuto(yawControl).getY());
                Rotation2d robotRotation = driveTrain.getPose().getRotation();
                driveTrain.resetOdometryToPose(new Pose2d(visionTrans, robotRotation));
            }
        }
    }
}
