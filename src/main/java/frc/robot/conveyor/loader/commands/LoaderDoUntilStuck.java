package frc.robot.conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.loader.Loader;

import static frc.robot.conveyor.loader.LoaderConstants.*;

class LoaderDoUntilStuck extends ParallelDeadlineGroup {
    LoaderDoUntilStuck(Loader loader, Command command) {
        super(new WaitCommand(UNCLOG_CHECK_DELAY).andThen(new WaitUntilCommand(loader::isStuck)), command);

    }
}
