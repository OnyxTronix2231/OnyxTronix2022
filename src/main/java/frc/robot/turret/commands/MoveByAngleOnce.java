package frc.robot.turret.commands;

import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class MoveByAngleOnce extends MoveByAngle {
    public MoveByAngleOnce (Turret turret, DoubleSupplier angelSupplier){
        super(turret, angelSupplier);
    }

    @Override
    public boolean isFinished() {
        return turret.IsOnTarget();
    }
}
