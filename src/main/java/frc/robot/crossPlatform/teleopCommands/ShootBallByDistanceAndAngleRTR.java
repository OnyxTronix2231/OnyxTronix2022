package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.BALL_TRIGGER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.LOADER_SPEED;

public class ShootBallByDistanceAndAngleRTR extends ParallelCommandGroup {

    public ShootBallByDistanceAndAngleRTR(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                                          DoubleSupplier rpm, DoubleSupplier arcAngle) {
        super(
                new GetReadyToShoot(shooter, arc, turret, rpm, arcAngle),
                new WaitUntilReadyToShoot(shooter::isOnTarget, arc::isOnTarget, turret::isOnTarget).andThen(
                        new MoveConveyor(loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED))
        );
    }
}
