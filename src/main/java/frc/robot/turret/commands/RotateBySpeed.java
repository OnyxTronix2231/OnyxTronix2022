package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class RotateBySpeed extends CommandBase {

    private final Turret turret;
    private final DoubleSupplier speedSupplier;

    public RotateBySpeed(Turret turret, DoubleSupplier speedSupplier) {
        this.turret = turret;
        this.speedSupplier = speedSupplier;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.setSpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        turret.stop();
    }
}
