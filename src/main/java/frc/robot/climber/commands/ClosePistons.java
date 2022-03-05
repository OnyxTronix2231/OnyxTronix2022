package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;

public class ClosePistons extends InstantCommand {

    public ClosePistons(Climber climber) {
        super(climber::closePistons);
    }
}
