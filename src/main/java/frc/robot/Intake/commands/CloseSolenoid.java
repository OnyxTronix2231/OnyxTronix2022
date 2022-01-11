package frc.robot.Intake.commands;

import frc.robot.Intake.Intake;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class CloseSolenoid extends InstantCommand {
    public CloseSolenoid(Intake intake) {
        super(intake::closeSolenoid);
    }
}
