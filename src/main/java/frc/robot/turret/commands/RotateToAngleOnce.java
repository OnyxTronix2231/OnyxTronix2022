package frc.robot.turret.commands;

import frc.robot.turret.Turret;
import java.util.function.DoubleSupplier;

public class RotateToAngleOnce extends RotateToAngle {

    public RotateToAngleOnce(Turret turret, DoubleSupplier angleSupplier) {
        super(turret, angleSupplier);
    }

    @Override
    public boolean isFinished() {
        return turret.isOnTarget();
    }
}
