package frc.robot.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooter.Shooter;
import java.util.function.DoubleSupplier;

public class ShootBySpeed extends CommandBase {

    private Shooter shooter;
    private DoubleSupplier speed;

    public ShootBySpeed(Shooter shooter, DoubleSupplier speedSupplier) {
        this.shooter = shooter;
        this.speed = speedSupplier;
    }

    @Override
    public void execute() {
        shooter.setSpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
