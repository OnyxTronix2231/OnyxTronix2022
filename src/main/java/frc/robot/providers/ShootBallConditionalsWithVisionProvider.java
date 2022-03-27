package frc.robot.providers;

import frc.robot.arc.Arc;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class ShootBallConditionalsWithVisionProvider extends ShootBallConditionsProvider{


    public ShootBallConditionalsWithVisionProvider(Shooter shooter, Turret turret, Arc arc,
                                                   DriveTrain driveTrain) {
        super(shooter, turret, arc, driveTrain);
    }

    @Override
    public boolean getAsBoolean() {
        return super.getAsBoolean() && Vision.getInstance().hasTarget();
    }
}
