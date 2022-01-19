package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Shooter.Shooter;

import java.util.function.DoubleSupplier;

public class ShootBySpeed extends CommandBase {
    private Shooter shooter;
    private double speed;

    public ShootBySpeed(Shooter shooter, double speed) {
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
