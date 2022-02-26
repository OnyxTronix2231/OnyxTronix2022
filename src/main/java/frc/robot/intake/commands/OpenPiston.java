package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intake.Intake;

public class OpenPiston extends InstantCommand {

    public OpenPiston(Intake intake) {
        super(intake::openPiston);
    }
}
