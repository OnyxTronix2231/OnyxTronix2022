package frc.robot.turret.commands;

import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class RotateByAngleConstantly extends RotateToAngleRTR {

    public RotateByAngleConstantly(Turret turret, DoubleSupplier angleSupplier) {
        super(turret, () -> (angleSupplier.getAsDouble() + turret.getCurrentAngleRTR()));

    }
}
