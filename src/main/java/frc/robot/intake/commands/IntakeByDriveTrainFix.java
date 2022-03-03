package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrainFix extends ConditionalCommand {

    public IntakeByDriveTrainFix(Intake intake, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                                 DriveTrain driveTrain, double joystickDeadband) {
        super(new ConditionalCommand(new OpenAndIntake(intakeBack, intakeSpeedSupplier),
                        new OpenAndIntake(intake, intakeSpeedSupplier), () -> driveTrain.getForwardSpeedValue() < 0),
                new InstantCommand(), () -> driveTrain.getForwardSpeedValue() != 0);
    }
}
