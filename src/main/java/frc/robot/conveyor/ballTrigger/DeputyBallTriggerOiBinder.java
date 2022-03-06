package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.BALLTRIGGER_SPEED;
import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.EJECT_BALLTRIGGER_SPEED;

public class DeputyBallTriggerOiBinder {

    public DeputyBallTriggerOiBinder(BallTrigger ballTrigger, Trigger feedShooterWithBalls, Trigger ejectBallTriggerBalls) {
        feedShooterWithBalls.whileActiveContinuous(new MoveBallTriggerBySpeed(ballTrigger, () -> BALLTRIGGER_SPEED));
        ejectBallTriggerBalls.whileActiveContinuous(new MoveBallTriggerBySpeed(ballTrigger, () -> EJECT_BALLTRIGGER_SPEED));
    }
}
