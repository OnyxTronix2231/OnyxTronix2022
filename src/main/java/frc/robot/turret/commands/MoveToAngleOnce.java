package frc.robot.turret.commands;

import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class MoveToAngleOnce extends MoveToAngle{

    public MoveToAngleOnce(Turret turret, DoubleSupplier angleSupplier) {
        super(turret, angleSupplier);
    }

    @Override
    public boolean isFinished() {
        return turret.IsOnTarget();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}
