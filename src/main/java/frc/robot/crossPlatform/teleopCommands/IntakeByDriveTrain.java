package frc.robot.crossPlatform.teleopCommands;

import frc.robot.driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {

    public IntakeByDriveTrain(Intake intakeForward, Intake intakeBack, DoubleSupplier intakeSpeedSupplier,
                              DriveTrainJoystickValueProvider joystickValueProvider) {
        super(new WaitUntilCommand(() -> !joystickValueProvider.isForward())
                        .deadlineWith(new OpenAndIntake(intakeForward, intakeSpeedSupplier)),
                new WaitUntilCommand(joystickValueProvider::isForward)
                        .deadlineWith(new OpenAndIntake(intakeBack, intakeSpeedSupplier)),
                joystickValueProvider::isForward);
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
