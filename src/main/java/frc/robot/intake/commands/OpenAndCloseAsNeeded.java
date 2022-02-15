package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.intake.Intake;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


public class OpenAndCloseAsNeeded extends ConditionalCommand {

    public OpenAndCloseAsNeeded(Intake intake, DoubleSupplier speedSupplier, Command onTrue, Command onFalse, BooleanSupplier condition) {
        super(new OpenAndIntake(intake, speedSupplier), new ClosePiston(intake), intake.isMotorSpin());
    }
}
