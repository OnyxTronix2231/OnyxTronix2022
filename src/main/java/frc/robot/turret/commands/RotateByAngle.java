package frc.robot.turret.commands;

import frc.robot.turret.Turret;
import java.util.function.DoubleSupplier;

public class RotateByAngle extends RotateToAngleRTR {

    public RotateByAngle(Turret turret, DoubleSupplier angleSupplier) {
        super(turret, () -> (angleSupplier.getAsDouble() + turret.getCurrentAngleRTR()));
    }
}
