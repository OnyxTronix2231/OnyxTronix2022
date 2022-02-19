package frc.robot.vision.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.vision.Vision;

public class ActByVision extends ConditionalCommand {

    public ActByVision(Command onTrue, Vision vision) {
        this(onTrue, new InstantCommand(), vision);
    }

    public ActByVision(Command onTrue, Command onFalse, Vision vision) {
        super(onTrue, onFalse, vision::hasTarget);
    }
}
