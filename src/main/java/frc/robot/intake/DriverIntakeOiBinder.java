package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.intake.commands.ToggleIntakeSides;

import static frc.robot.intake.IntakeConstant.INTAKE_SPEED;

public class DriverIntakeOiBinder {

    public DriverIntakeOiBinder(Intake intakeForward, Intake intakeBack, Trigger openAndCloseAsNeeded) {
        openAndCloseAsNeeded.whileActiveContinuous(new ToggleIntakeSides(intakeForward, intakeBack,
                () -> INTAKE_SPEED));

    }
}

