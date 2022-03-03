package frc.robot.crossPlatform.teleopCommands;

import frc.robot.conveyor.commands.OnyxParallelDeadlineGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class OpenIntakeBackAccordingToDriveTrain extends OnyxParallelDeadlineGroup {

    public OpenIntakeBackAccordingToDriveTrain(DriveTrain driveTrain, Intake intakeBack, double joystickDeadband
            , DoubleSupplier intakeSpeedSupplier) {
        super(() -> driveTrain.getForwardSpeedValue() > joystickDeadband &&
                        Math.abs(driveTrain.getForwardSpeedValue()) > joystickDeadband,
                new OpenAndIntake(intakeBack, intakeSpeedSupplier));
    }

    @Override
    public void initialize() {
        super.initialize();
        Intake.setIsForward(false);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if (!interrupted) {
            Intake.setIsForward(true);
        }
    }
}
