package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.drivetrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class TurnByAngle extends CommandBase {

    private final DriveTrain driveTrain;
    private final DoubleSupplier angleSupplier;


    public TurnByAngle(DriveTrain driveTrain, DoubleSupplier angleSupplier) {
        this.driveTrain = driveTrain;
        this.angleSupplier = angleSupplier;
    }
}
