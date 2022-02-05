package frc.robot.loader.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.loader.Loader;
import static frc.robot.loader.LoaderConstants.*;

public class UntilStuck extends ParallelDeadlineGroup {
    public UntilStuck(Loader loader, Command command) {
        super(new WaitCommand(UNCLOG_CHECK_DELAY).andThen(new WaitUntilCommand(loader::isStuck)), command);
    }
}
