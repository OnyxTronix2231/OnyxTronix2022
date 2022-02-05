package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intake.Intake;

public class OpenSolenoid extends InstantCommand {

    public OpenSolenoid(Intake intake) {
        super(intake::openSolenoid);
        addRequirements(intake);
    }
}
