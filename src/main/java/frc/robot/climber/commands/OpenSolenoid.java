package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;


public class OpenSolenoid extends InstantCommand {

    public OpenSolenoid(Climber climber) {
        super(climber::openSolenoid, climber);
    }
}
