package frc.robot.providers;

import frc.robot.arc.Arc;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;

public class ShootBallConditionsProvider implements BooleanSupplier {

    private final Shooter shooter;
    private final Turret turret;
    private final Arc arc;
    private final DriveTrain driveTrain;

    public ShootBallConditionsProvider(Shooter shooter, Turret turret, Arc arc, DriveTrain driveTrain){
        this.shooter = shooter;
        this.turret = turret;
        this.arc = arc;
        this.driveTrain = driveTrain;
    }

    @Override
    public boolean getAsBoolean() {
        return ((shooter.isOnTarget() && turret.isOnTarget() && arc.isOnTarget()) || shooter.isRealeBallsButtonpress()) && (driveTrain.forwardSpeedValue == 0);
    }
}
