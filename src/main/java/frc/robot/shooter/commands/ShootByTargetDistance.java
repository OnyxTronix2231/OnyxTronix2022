package frc.robot.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.providers.IsLoadBallButtonPress;
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
        shooter.initShootByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        shooter.updateShootByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        if (!IsLoadBallButtonPress.isPress()) {
            shooter.stop();
        }
    }
}
