package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.loader.Loader;
import frc.robot.trigger.Triggerr;

import static frc.robot.loader.LoaderConstants.UNCLOG_CHECK_DELAY;

public class UntilStuck extends ParallelDeadlineGroup {
    public UntilStuck(Triggerr triggerr, Command command) {
        super(new WaitCommand(UNCLOG_CHECK_DELAY).andThen(new WaitUntilCommand(triggerr::isStuck)), command);
    }
}
