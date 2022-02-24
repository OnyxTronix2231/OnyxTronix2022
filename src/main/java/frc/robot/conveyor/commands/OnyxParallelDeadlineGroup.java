package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import java.util.function.BooleanSupplier;

public class OnyxParallelDeadlineGroup extends ParallelDeadlineGroup {

    public OnyxParallelDeadlineGroup(BooleanSupplier condition, Command... commands) {
        super(new WaitUntilCommand(condition), new WaitUntilCommand(() -> !condition.getAsBoolean()).andThen(commands));
    }
}
