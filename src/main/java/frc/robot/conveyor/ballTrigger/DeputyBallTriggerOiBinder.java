package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.MOVE_BALL_TO_LOADER_FROM_BALLTRIGGER_SPEED;

public class DeputyBallTriggerOiBinder {

    public DeputyBallTriggerOiBinder(BallTrigger ballTrigger, Trigger moveBallFromBallTriggerToLoader) {
        moveBallFromBallTriggerToLoader.whileActiveContinuous(new MoveBallTriggerBySpeed(ballTrigger, () -> MOVE_BALL_TO_LOADER_FROM_BALLTRIGGER_SPEED));
    }
}
