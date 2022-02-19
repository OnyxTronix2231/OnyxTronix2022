package frc.robot.Conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class PressTrigger extends ParallelDeadlineGroup {
    public PressTrigger(BallTrigger trigger, DoubleSupplier triggerSpeedSupplier) {
        super(new WaitCommand(5), new TriggerMoveBySpeed(trigger, triggerSpeedSupplier));
    }
}
