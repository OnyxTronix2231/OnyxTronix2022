package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.climber.Climber;


public class CloseSolenoid extends InstantCommand {

    public CloseSolenoid(Climber climber) {
        super(climber::closeSolenoid, climber);
    }
}
