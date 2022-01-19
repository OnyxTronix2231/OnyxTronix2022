package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootBySpeedWood extends CommandBase {
    private ShooterWood shooter;
    private double speed;

    public ShootBySpeedWood(ShooterWood shooter, double speed) {
        this.shooter = shooter;
        this.speed = speed;
    }

    public void execute() {
        shooter.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

}
