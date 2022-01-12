package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;
import java.util.function.DoubleSupplier;

public class RotateTurretBySpeed extends CommandBase {

    private Turret turret;
    private DoubleSupplier speed;

    public RotateTurretBySpeed(Turret turret, DoubleSupplier speed) {
        this.turret = turret;
        this.speed = speed;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.setSpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        turret.stop();
    }
}
