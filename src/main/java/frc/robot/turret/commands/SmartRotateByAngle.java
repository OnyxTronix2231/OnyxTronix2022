package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class SmartRotateByAngle extends CommandBase {

    private final Turret turret;
    private final DoubleSupplier angleSupplier;

    public SmartRotateByAngle(Turret turret, DoubleSupplier angleSupplier) {
        this.turret = turret;
        this.angleSupplier = angleSupplier;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        turret.initMoveByDegree(angleSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        turret.updateMoveByDegree(angleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        turret.stop();
    }
}
