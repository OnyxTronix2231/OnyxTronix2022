package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public class IntakeOiBinder {
    public IntakeOiBinder(Intake intakeFront, Intake intakeBack, Trigger trigger) {
        trigger.whileActiveContinuous()

    }
}
