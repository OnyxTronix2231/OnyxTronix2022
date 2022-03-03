package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.commands.OnyxParallelDeadlineGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class OpenIntakeBackAccordingToDriveTrain extends OnyxParallelDeadlineGroup {

    private final Intake intakeBack;

    public OpenIntakeBackAccordingToDriveTrain(DriveTrain driveTrain, Intake intakeBack, double joystickDeadband
            , DoubleSupplier intakeSpeedSupplier) {
        super(()-> driveTrain.getForwardSpeedValue() > joystickDeadband,
                new OpenAndIntake(intakeBack, intakeSpeedSupplier));
        this.intakeBack = intakeBack;
    }

    @Override
    public void end(boolean interrupted) {
        if (!interrupted)
        intakeBack.setIsForward(true);
    }
}
