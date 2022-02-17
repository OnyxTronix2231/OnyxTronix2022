package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.OpenAndCloseAsNeeded;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class IntakeOiBinder {

    public IntakeOiBinder(Intake intakeForward,Intake intakeBack, JoystickButton openAndIntake, DoubleSupplier IntakeSpeedSupplier) {
        openAndIntake.toggleWhenPressed(new OpenAndCloseAsNeeded(intakeForward, intakeBack ,IntakeSpeedSupplier));
    }
}

