package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.ShootBallByDistanceAndAngleRTR;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

public class ShootWithDelay extends ParallelDeadlineGroup {

    public ShootWithDelay(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                          DistanceProvider distanceProvider, AngleProvider angleProvider) {
        super(new WaitCommand(2.5),new ShootBallByDistanceAndAngleRTR(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                angleProvider));
    }
}
