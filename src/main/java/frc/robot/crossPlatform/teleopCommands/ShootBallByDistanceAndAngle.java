package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;
import frc.robot.providers.ShootBallConditionsProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.BALL_TRIGGER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.LOADER_SPEED;

public class ShootBallByDistanceAndAngle extends ParallelCommandGroup {

    public ShootBallByDistanceAndAngle(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                                       DoubleSupplier distance, DoubleSupplier angle, BooleanSupplier conditions) {
        super(
                new GetReadyToShoot(shooter, arc, turret, distance, angle),
                new WaitUntilReadyToShoot(conditions).andThen(
                        new MoveConveyor(loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED))
        );
    }
}
