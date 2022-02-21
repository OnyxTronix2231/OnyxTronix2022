package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

public class BallTriggerOiBinder {

    public BallTriggerOiBinder(BallTrigger ballTrigger, Trigger trigger) {

        trigger.whileActiveContinuous(new MoveBallTriggerBySpeed(ballTrigger,()->0.5));
    }
}
