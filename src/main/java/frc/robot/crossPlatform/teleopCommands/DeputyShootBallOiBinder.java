package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;

public class DeputyShootBallOiBinder {

    public DeputyShootBallOiBinder(Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger,
                                   Trigger shootToEjectEnemyBalls) {
        shootToEjectEnemyBalls.whileActiveContinuous(new EjectEnemyBall(shooter, arc, loader, ballTrigger));
    }
}
