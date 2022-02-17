package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.TriggerMoveBySpeed;

import java.util.function.DoubleSupplier;

public class PressTrigger extends ParallelDeadlineGroup {
    public PressTrigger(BallTrigger trigger, DoubleSupplier triggerSpeedSupplier) {
        super(new WaitCommand(5), new TriggerMoveBySpeed(trigger, triggerSpeedSupplier));
    }
}
