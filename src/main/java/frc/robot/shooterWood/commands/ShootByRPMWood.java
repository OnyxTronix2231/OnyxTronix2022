package frc.robot.shooterWood.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootByRPMWood extends CommandBase {

    private final ShooterWood shooterWood;
    private final DoubleSupplier speedSupplier;

    public ShootByRPMWood(ShooterWood shooterWood, DoubleSupplier rpm) {
        this.shooterWood = shooterWood;
        this.speedSupplier = rpm;
    }

    @Override
    public void initialize() {
        shooterWood.initMoveByRPM(speedSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        shooterWood.updateMoveByRPM(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }
}
