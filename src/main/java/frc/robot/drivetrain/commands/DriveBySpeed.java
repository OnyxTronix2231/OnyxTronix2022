package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.drivetrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class DriveBySpeed extends CommandBase {

    private final DoubleSupplier speedSupplier;
    private final DoubleSupplier rotationSupplier;
    private final DriveTrain driveTrain;

    public DriveBySpeed(DriveTrain driveTrain, DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier) {
        this.speedSupplier = speedSupplier;
        this.rotationSupplier = rotationSupplier;
        this.driveTrain = driveTrain;

        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        System.out.println(driveTrain.getPose());
        System.out.println(driveTrain.getHeading());
        driveTrain.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
