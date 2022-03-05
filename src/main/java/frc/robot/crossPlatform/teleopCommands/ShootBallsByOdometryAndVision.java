package frc.robot.crossPlatform.teleopCommands;

import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class ShootBallsByOdometryAndVision extends ShootBallByDistanceAndAngleRTR{

    public ShootBallsByOdometryAndVision(Shooter shooter, Arc arc, Turret turret, Loader loader,
                                         BallTrigger ballTrigger, DistanceProvider distance, AngleProvider angle) {
        super(shooter, arc, turret, loader, ballTrigger, distance, angle);
    }
}
