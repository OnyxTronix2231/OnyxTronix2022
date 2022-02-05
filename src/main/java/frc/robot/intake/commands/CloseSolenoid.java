package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intake.Intake;

public class CloseSolenoid extends InstantCommand {
    public CloseSolenoid(Intake intake) {
        super(intake::closeSolenoid);
        addRequirements(intake);
    }
}
