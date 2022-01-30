package frc.robot.shooterWood.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooterWood.ShooterWood;
import java.util.function.DoubleSupplier;

public class ShootByRPMWood extends CommandBase {

    private ShooterWood shooterWood;
    private DoubleSupplier rpmSupplier;

    public ShootByRPMWood(ShooterWood shooterWood, DoubleSupplier rpm) {
        this.shooterWood = shooterWood;
        this.rpmSupplier = rpm;
    }

    @Override
    public void initialize() {
        shooterWood.initMoveByRPM(rpmSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        shooterWood.updateMoveByRPM(rpmSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }
}
