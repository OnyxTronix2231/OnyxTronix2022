package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;

public class OpenPistons extends InstantCommand {

    public OpenPistons(Climber climber) {
        super(climber::openPistons);
    }
}
