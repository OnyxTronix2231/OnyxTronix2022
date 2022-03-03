package frc.robot.crossPlatform.teleopCommands;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {

    public IntakeByDriveTrain(Intake intakeForward, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                              DriveTrainJoystickValueProvider intakeControl) {
        super(new WaitUntilCommand(intakeControl::isForward)
                        .deadlineWith(new OpenAndIntake(intakeBack, intakeSpeedSupplier)),
                new WaitUntilCommand(intakeControl::isForward)
                        .deadlineWith(new OpenAndIntake(intakeForward, intakeSpeedSupplier)),
                intakeControl::isForward);
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
