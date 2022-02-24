package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class ToggleIntakeSides extends ConditionalCommand {

    public ToggleIntakeSides(Intake intakeFront, Intake intakeBack, DoubleSupplier speedSupplier) {
        super(new OpenAndIntake(intakeBack, speedSupplier), new OpenAndIntake(intakeFront, speedSupplier),
                intakeFront::isFrontIntakeOpen);
    }
}
