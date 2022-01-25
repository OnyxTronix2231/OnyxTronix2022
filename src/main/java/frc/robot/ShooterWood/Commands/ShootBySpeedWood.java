package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootBySpeedWood extends CommandBase {

    private ShooterWood shooterWood;
    private DoubleSupplier speed;

    public ShootBySpeedWood(ShooterWood shooterWood, DoubleSupplier speed) {
        this.shooterWood = shooterWood;
        this.speed = speed;
    }

    public void execute() {
        shooterWood.setSpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }

}
