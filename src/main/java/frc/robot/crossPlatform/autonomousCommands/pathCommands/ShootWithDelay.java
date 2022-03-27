package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.ShootBallByDistanceAndAngle;
import frc.robot.providers.*;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ShootWithDelay extends ParallelDeadlineGroup {

    public ShootWithDelay(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                          DoubleSupplier distanceProvider, DoubleSupplier angleProvider,
                          BooleanSupplier shooterConditions) {
        super(new ShootBallByDistanceAndAngle(shooter, arc, turret, loader, ballTrigger,
                distanceProvider,
                angleProvider
                , shooterConditions).withTimeout(2.5));
    }
}
