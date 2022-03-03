package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.commands.OnyxParallelDeadlineGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class OpenIntakeFrontAccordingToDriveTrain extends OnyxParallelDeadlineGroup {

    private final Intake intakeForward;

    public OpenIntakeFrontAccordingToDriveTrain(DriveTrain driveTrain, Intake intakeForward, double joystickDeadband
            , DoubleSupplier intakeSpeedSupplier) {
        super(() -> driveTrain.getForwardSpeedValue() < joystickDeadband,
                new OpenAndIntake(intakeForward, intakeSpeedSupplier));
        this.intakeForward = intakeForward;
    }

    @Override
    public void initialize() {
        super.initialize();
        intakeForward.setIsForward(true);
    }
}
