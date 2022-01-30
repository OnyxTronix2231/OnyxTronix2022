package frc.robot.drivetrain.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;

public class ResetOdometryToPose extends InstantCommand {

    public ResetOdometryToPose(DriveTrain driveTrain, Translation2d translation) {
        super(() -> driveTrain.resetOdometryToPose(translation));
    }
}
