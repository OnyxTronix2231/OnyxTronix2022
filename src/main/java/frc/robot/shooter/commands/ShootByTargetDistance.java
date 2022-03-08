package frc.robot.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooter.Shooter;

import java.util.function.DoubleSupplier;

public class ShootByTargetDistance extends CommandBase {

    private final Shooter shooter;
    private final DoubleSupplier distanceSupplier;

    public ShootByTargetDistance(Shooter shooter, DoubleSupplier distanceSupplier) {
        this.shooter = shooter;
        this.distanceSupplier = distanceSupplier;
    }

    @Override
    public void initialize() {
        System.out.println(distanceSupplier.getAsDouble());
        shooter.initShootByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        shooter.updateShootByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
        System.out.println(shooter.getCurrentRPM());
    }
}
