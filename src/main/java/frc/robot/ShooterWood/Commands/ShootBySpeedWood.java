package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootBySpeedWood extends CommandBase {
    private ShooterWood shooter;
    private DoubleSupplier speed;

    public ShootBySpeedWood(ShooterWood shooter, DoubleSupplier speed) {
        this.shooter = shooter;
        this.speed = speed;
    }

    public void execute() {
        shooter.setSpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

}
