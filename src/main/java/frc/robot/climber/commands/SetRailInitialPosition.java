package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;

public class SetRailInitialPosition extends InstantCommand {

    public SetRailInitialPosition(Climber climber) {
        super(climber::setRailInitialPosition, climber);
    }
}
