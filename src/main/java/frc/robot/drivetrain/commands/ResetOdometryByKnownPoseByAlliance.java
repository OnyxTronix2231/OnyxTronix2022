package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.drivetrain.DriveTrain;

public class ResetOdometryByKnownPoseByAlliance extends ConditionalCommand {

    public ResetOdometryByKnownPoseByAlliance(DriveTrain driveTrain) {
        super(new ResetOdometryToKnownPoseRed(driveTrain), new ResetOdometryToKnownPoseBlue(driveTrain),
                () -> DriverStation.getAlliance() == DriverStation.Alliance.Red);
    }
}
