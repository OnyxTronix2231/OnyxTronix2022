package frc.robot.intakeForward.commands;

import frc.robot.intakeForward.IntakeForward;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class CloseSolenoid extends InstantCommand {
    public CloseSolenoid(IntakeForward intake) {
        super(intake::closeSolenoid);
        addRequirements(intake);
    }
}
