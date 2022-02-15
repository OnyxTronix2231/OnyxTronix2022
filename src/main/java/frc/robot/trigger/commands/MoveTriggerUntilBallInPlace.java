package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.TriggerMoveBySpeed;

import java.util.function.DoubleSupplier;

public class MoveTriggerUntilBallInPlace extends ParallelDeadlineGroup {
    public MoveTriggerUntilBallInPlace(BallTrigger trigger, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(trigger::isLoadedRev), new TriggerMoveBySpeed(trigger, speedSupplier));
    }
}
