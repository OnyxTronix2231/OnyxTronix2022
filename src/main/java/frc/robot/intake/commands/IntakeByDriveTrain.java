package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {

    public IntakeByDriveTrain(Intake intakeFront, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                              DriveTrain driveTrain, double joystickDeadband) {
        super(new OpenIntakeBackAccordingToDriveTrain(driveTrain, intakeBack, joystickDeadband, intakeSpeedSupplier),
               new OpenIntakeFrontAccordingToDriveTrain(driveTrain, intakeFront, joystickDeadband, intakeSpeedSupplier),
                () -> Intake.isForward);
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            end(false);
            initialize();
        }
        return false;
    }
}
