package frc.robot.intakeForward.commands;

import frc.robot.intakeForward.IntakeForward;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class OpenSolenoid extends InstantCommand {

    public OpenSolenoid(IntakeForward intake) {
        super(intake::openSolenoid);
        addRequirements(intake);
    }
}
