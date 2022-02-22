package frc.robot.conveyor.commandsv2;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import java.util.function.DoubleSupplier;

public class TriggerUntilBallsInPlace extends OnyxParallelDeadlineGroup {
    public TriggerUntilBallsInPlace(BallTrigger ballTrigger, DoubleSupplier speedSupplier) {
        super(ballTrigger::isBallInPlace, new WaitUntilCommand(ballTrigger::isBallIdentified).
                andThen(new MoveBallTriggerBySpeed(ballTrigger, speedSupplier)));
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            end(false);
            initialize();
        }
        return false;
    }
}
