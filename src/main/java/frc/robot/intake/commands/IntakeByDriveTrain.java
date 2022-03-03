package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {

    public IntakeByDriveTrain(Intake intakeForward, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                              DriveTrain driveTrain, double joystickDeadband) {
        super(new WaitUntilCommand(() -> intakeForward.getJoyStickValue() < -joystickDeadband)
                        .deadlineWith(new OpenAndIntake(intakeBack, intakeSpeedSupplier)),
                new WaitUntilCommand(() -> intakeForward.getJoyStickValue() > joystickDeadband)
                        .deadlineWith(new OpenAndIntake(intakeForward, intakeSpeedSupplier)),
                () -> intakeForward.getJoyStickValue() > joystickDeadband);
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
