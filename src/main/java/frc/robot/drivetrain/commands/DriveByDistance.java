package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;

public class DriveByDistance extends CommandBase {

    private final double distance;
    private final DriveTrain driveTrain;

    public DriveByDistance(double distance, DriveTrain driveTrain) {
        this.distance = distance;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.driveByDistance(distance);
    }
}
