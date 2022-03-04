package frc.robot.drivetrain.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;

public class ResetOdometryToPose extends InstantCommand {

    public ResetOdometryToPose(DriveTrain driveTrain, Translation2d translation) {
        super(() -> driveTrain.resetOdometryToPose(translation));
    }

    public ResetOdometryToPose(DriveTrain driveTrain, Pose2d pose) {
        super(() -> driveTrain.resetOdometryToPose(pose));
    }
}
