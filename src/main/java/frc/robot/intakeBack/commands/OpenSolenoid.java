package frc.robot.intakeBack.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intakeBack.IntakeBack;

public class OpenSolenoid extends InstantCommand {

    public OpenSolenoid(IntakeBack intakeBack) {
        super(intakeBack::openSolenoid);
        addRequirements(intakeBack);
    }
}
