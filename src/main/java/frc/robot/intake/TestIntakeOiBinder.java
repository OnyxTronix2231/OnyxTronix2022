package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.MoveIntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

import static frc.robot.intake.IntakeConstant.INTAKE_SPEED;

public class TestIntakeOiBinder {

    public TestIntakeOiBinder(Intake intakeFront, Intake intakeBack, Trigger openFrontIntake, Trigger openBackIntake,
                              Trigger closeFrontIntake, Trigger closeBackIntake, Trigger moveFrontIntake,
                              Trigger moveBackIntake) {
        openFrontIntake.whenActive(new OpenPiston(intakeFront));
        openBackIntake.whenActive(new OpenPiston(intakeBack));

        closeFrontIntake.whenActive(new ClosePiston(intakeFront));
        closeBackIntake.whenActive(new ClosePiston(intakeBack));

        moveFrontIntake.whileActiveContinuous(new MoveIntakeBySpeed(intakeFront, () -> INTAKE_SPEED));
        moveBackIntake.whileActiveContinuous(new MoveIntakeBySpeed(intakeBack, () -> INTAKE_SPEED));


    }
}
