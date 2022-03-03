package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {

    public IntakeByDriveTrain(Intake intakeFront, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                              DriveTrain driveTrain, double joystickDeadband) {
        super(new OpenIntakeFrontAccordingToDriveTrain(driveTrain, intakeFront, joystickDeadband, intakeSpeedSupplier),
                new OpenIntakeBackAccordingToDriveTrain(driveTrain, intakeBack, joystickDeadband, intakeSpeedSupplier),
                ()-> Math.abs(driveTrain.getForwardSpeedValue()) < joystickDeadband  ? Intake.getIsForward() :
                        driveTrain.getForwardSpeedValue() > joystickDeadband );
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
