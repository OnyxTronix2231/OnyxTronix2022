package frc.robot.intake;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.commands.IntakeByDriveTrain;
import humanControls.JoystickAxis;

import java.util.function.DoubleSupplier;

import static frc.robot.intake.IntakeConstant.INTAKE_SPEED;

public class IntakeOiBinder {

    public IntakeOiBinder(DriveTrain driveTrain, Intake intakeForward, Intake intakeBack,
                          JoystickAxis openAndIntakeTwoSides, DoubleSupplier IntakeSpeedSupplier) {
        openAndIntakeTwoSides.whileActiveContinuous(new IntakeByDriveTrain(intakeForward, intakeBack,
                () -> INTAKE_SPEED, driveTrain));
    }
}

