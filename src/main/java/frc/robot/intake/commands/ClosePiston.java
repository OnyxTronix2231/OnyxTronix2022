package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.intake.Intake;

public class ClosePiston extends InstantCommand {

    public ClosePiston(Intake intake) {
        super(intake::closePiston);
        addRequirements(intake);
    }
}
