package frc.robot.intakeBack.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intakeBack.IntakeBack;

public class CloseSolenoid extends InstantCommand {
    public CloseSolenoid(IntakeBack intakeBack) {
        super(intakeBack::closeSolenoid);
        addRequirements(intakeBack);
    }
}
