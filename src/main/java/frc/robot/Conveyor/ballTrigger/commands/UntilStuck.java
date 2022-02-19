package frc.robot.Conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Conveyor.ballTrigger.BallTrigger;

import static frc.robot.Conveyor.loader.LoaderConstants.UNCLOG_CHECK_DELAY;

public class UntilStuck extends ParallelDeadlineGroup {
    public UntilStuck(BallTrigger triggerr, Command command) {
        super(new WaitCommand(UNCLOG_CHECK_DELAY).andThen(new WaitUntilCommand(triggerr::isStuck)), command);
    }
}