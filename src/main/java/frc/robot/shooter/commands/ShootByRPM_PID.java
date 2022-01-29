package frc.robot.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooter.Shooter;

import java.util.function.DoubleSupplier;

public class ShootByRPM_PID extends CommandBase {

    private Shooter shooter;
    private DoubleSupplier rpm;

    public ShootByRPM_PID(Shooter shooter, DoubleSupplier rpm) {
        this.shooter = shooter;
        this.rpm = rpm;
    }

    @Override
    public void initialize() {
        shooter.initSetPIDSpeed(rpm.getAsDouble());
    }

    @Override
    public void execute() {
        shooter.updateSetPIDSpeed(rpm.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
