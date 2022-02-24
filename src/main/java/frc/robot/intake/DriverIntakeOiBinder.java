package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.intake.commands.OpenAndCloseAsNeeded;

import static frc.robot.intake.IntakeConstant.INTAKE_SPEED;

public class DriverIntakeOiBinder {

    public DriverIntakeOiBinder(Intake intakeForward, Intake intakeBack, Trigger openAndIntakeTwoSides) {
        openAndIntakeTwoSides.whileActiveContinuous(new OpenAndCloseAsNeeded(intakeForward, intakeBack,
                () -> INTAKE_SPEED));

    }
}

