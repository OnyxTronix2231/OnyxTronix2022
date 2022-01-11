package frc.robot.Intake.commands;

import frc.robot.Intake.Intake;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class OpenSolenoid extends InstantCommand {
    public OpenSolenoid(Intake intake) {
        super(intake::openSolenoid);
    }
}
