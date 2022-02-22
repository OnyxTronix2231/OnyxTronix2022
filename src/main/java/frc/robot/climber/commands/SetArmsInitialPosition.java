package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;

public class SetArmsInitialPosition extends InstantCommand {

    public SetArmsInitialPosition(Climber climber) {
        super(climber::setArmsInitialPosition, climber);
    }
}
