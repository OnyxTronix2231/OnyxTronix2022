package frc.robot.crossPlatform.teleopCommands;

import frc.robot.conveyor.commands.OnyxParallelDeadlineGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class OpenIntakeFrontAccordingToDriveTrain extends OnyxParallelDeadlineGroup {

    public OpenIntakeFrontAccordingToDriveTrain(DriveTrain driveTrain, Intake intakeForward, double joystickDeadband
            , DoubleSupplier intakeSpeedSupplier) {
        super(() -> driveTrain.getForwardSpeedValue() < joystickDeadband &&
                        Math.abs(driveTrain.getForwardSpeedValue()) > joystickDeadband,
                new OpenAndIntake(intakeForward, intakeSpeedSupplier));
    }

    @Override
    public void initialize() {
        super.initialize();
        Intake.setIsForward(true);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if (!interrupted) {
            Intake.setIsForward(false);
        }
    }
}
