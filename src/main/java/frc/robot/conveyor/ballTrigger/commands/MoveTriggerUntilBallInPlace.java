package frc.robot.conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class MoveTriggerUntilBallInPlace extends ParallelDeadlineGroup {

    public MoveTriggerUntilBallInPlace(BallTrigger ballTrigger, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(ballTrigger::isBallInPlace), new TriggerMoveBySpeed(ballTrigger, speedSupplier));
    }
}
