package frc.robot.providers;

import frc.robot.arc.Arc;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;

public class ShootBallConditionsProvider implements BooleanSupplier {

    private final Shooter shooter;
    private final Turret turret;
    private final Arc arc;

    public ShootBallConditionsProvider(Shooter shooter, Turret turret, Arc arc){
        this.shooter = shooter;
        this.turret = turret;
        this.arc = arc;
    }

    @Override
    public boolean getAsBoolean() {
        return (shooter.isOnTarget() && turret.isOnTarget() && arc.isOnTarget()) || shooter.isPress();
    }
}
