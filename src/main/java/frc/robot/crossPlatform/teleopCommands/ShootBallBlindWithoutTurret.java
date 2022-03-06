package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateToAngleRTR;

import java.util.function.DoubleSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.BALL_TRIGGER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.LOADER_SPEED;

public class ShootBallBlindWithoutTurret extends ParallelCommandGroup {

    public ShootBallBlindWithoutTurret(Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger,
                          DoubleSupplier speedSupplier, DoubleSupplier arcAngle) {
        super(
                new ShootByRPM(shooter, speedSupplier),
                new MoveArcToAngle(arc, arcAngle),
                new WaitUntilReadyToShoot(shooter::isOnTarget, arc::isOnTarget).andThen(
                        new MoveConveyor(loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED)));
    }
}
