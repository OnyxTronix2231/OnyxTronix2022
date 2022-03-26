package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.ShootBallByDistanceAndAngle;
import frc.robot.providers.*;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

public class ShootWithDelay extends ParallelDeadlineGroup {

    public ShootWithDelay(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                          DistanceProvider distanceProvider, AngleProvider angleProvider) {
        super(new ShootBallByDistanceAndAngle(shooter, arc, turret, loader, ballTrigger,
                distanceProvider,
                angleProvider
                , new ShootBallConditionsProvider(shooter, turret, arc)).withTimeout(2.5));
    }
}
