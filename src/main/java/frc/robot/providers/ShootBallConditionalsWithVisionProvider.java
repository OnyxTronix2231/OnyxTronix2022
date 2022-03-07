package frc.robot.providers;

import frc.robot.arc.Arc;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class ShootBallConditionalsWithVisionProvider extends ShootBallConditionsProvider{

    private final Vision vision;

    public ShootBallConditionalsWithVisionProvider(Shooter shooter, Turret turret, Arc arc, Vision vision) {
        super(shooter, turret, arc);
        this.vision = vision;
    }

    @Override
    public boolean getAsBoolean() {
        return super.getAsBoolean() && vision.hasTarget();
    }
}
