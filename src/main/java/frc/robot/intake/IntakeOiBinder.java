package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intake.commands.CloseSolenoid;
import frc.robot.intake.commands.OpenAndIntake;

public class IntakeOiBinder {

    public IntakeOiBinder(Intake intake, JoystickButton openAndIntake) {
        openAndIntake.toggleWhenPressed(new OpenAndIntake(intake, () -> 0.3))
                .cancelWhenPressed(new CloseSolenoid(intake));
    }
}

