package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class MoveByAngle extends CommandBase {
    private Turret turret;
    private DoubleSupplier angleSupplier;

    public MoveByAngle(Turret turret, DoubleSupplier angleSupplier) {
        this.turret = turret;
        this.angleSupplier = angleSupplier;


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