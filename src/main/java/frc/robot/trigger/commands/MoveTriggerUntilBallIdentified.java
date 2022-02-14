package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.TriggerMoveBySpeed;

import java.util.function.DoubleSupplier;

public class MoveTriggerUntilBallIdentified extends ParallelDeadlineGroup {
    public MoveTriggerUntilBallIdentified(BallTrigger trigger, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(trigger::isLoadedLevel2), new TriggerMoveBySpeed(trigger, speedSupplier));
    }

}
