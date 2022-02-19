package frc.robot.Conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class MoveTriggerUntilBallInPlace extends ParallelDeadlineGroup {
    public MoveTriggerUntilBallInPlace(BallTrigger trigger, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(trigger::isLoadedRev), new TriggerMoveBySpeed(trigger, speedSupplier));
    }
}
