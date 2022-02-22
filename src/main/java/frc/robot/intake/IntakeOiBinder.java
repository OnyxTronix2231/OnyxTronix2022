package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.commands.IntakeByDriveTrain;
import frc.robot.intake.commands.OpenAndCloseAsNeeded;

import static frc.robot.intake.IntakeConstant.INTAKE_SPEED;

public class IntakeOiBinder {

    public IntakeOiBinder(DriveTrain driveTrain, Intake intakeForward, Intake intakeBack,
                          
                          Trigger openAndIntakeTwoSides, Trigger IntakeByDriveTrain) {
        openAndIntakeTwoSides.whileActiveContinuous(new OpenAndCloseAsNeeded(intakeForward, intakeBack,
                () -> INTAKE_SPEED));

        IntakeByDriveTrain.whileActiveContinuous(new IntakeByDriveTrain(intakeForward, intakeBack,
                () -> INTAKE_SPEED, driveTrain));
    }
}

