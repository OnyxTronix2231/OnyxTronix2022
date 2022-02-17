package frc.robot.shooter.commands;

import frc.robot.shooter.Shooter;

import java.util.function.DoubleSupplier;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.distanceToRPM;

public class ShootByTargetDistance extends ShootByRPM {

    public ShootByTargetDistance(Shooter shooter, DoubleSupplier distanceSupplier) {
        super(shooter, ()-> distanceToRPM(distanceSupplier.getAsDouble()));
    }
}
