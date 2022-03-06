package frc.robot.crossPlatform.teleopCommands;

import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;

import java.util.function.DoubleSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.EJECT_BALL_ARC_ANGLE;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.EJECT_BALL_SHOOT_RPM;

public class EjectEnemyBall extends ShootBallBlindWithoutTurret {

    public EjectEnemyBall(Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger) {
        super(shooter, arc, loader, ballTrigger, () -> EJECT_BALL_SHOOT_RPM, () -> EJECT_BALL_ARC_ANGLE);
    }
}
