package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import java.util.function.DoubleSupplier;

public class MoveBallTriggerUntilBallInPlace extends OnyxParallelDeadlineGroup {
    public MoveBallTriggerUntilBallInPlace(BallTrigger ballTrigger, DoubleSupplier ballTriggerSpeedSupplier) {
        super(ballTrigger::isBallInPlaceV2, new WaitUntilCommand(ballTrigger::isBallIdentifiedV2).
                andThen(new MoveBallTriggerBySpeed(ballTrigger, ballTriggerSpeedSupplier)));
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
