package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;


public class OpenAndCloseAsNeeded extends ConditionalCommand {

    public OpenAndCloseAsNeeded(Intake intakeFront, Intake intakeBack, DoubleSupplier speedSupplier) {
        super(new OpenAndIntake(intakeBack, speedSupplier), new OpenAndIntake(intakeFront, speedSupplier), intakeFront::isFrontOpen);
    }
}
