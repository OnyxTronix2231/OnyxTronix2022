package frc.robot.shooterWood.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootBySpeedWood extends CommandBase {

    private ShooterWood shooterWood;
    private DoubleSupplier speedSupplier;

    public ShootBySpeedWood(ShooterWood shooterWood, DoubleSupplier speed) {
        this.shooterWood = shooterWood;
        this.speedSupplier = speed;
    }

    @Override
    public void execute() {
        shooterWood.setSpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }
}
