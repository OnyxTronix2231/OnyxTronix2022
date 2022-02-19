package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveByJoystick;
import frc.robot.drivetrain.commands.pathCommands.SecondPathOption;
import frc.robot.drivetrain.commands.pathCommands.TestCommand;
import humanControls.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis leftJoystick, JoystickAxis rightJoystick,
                                     Trigger buttonA, Trigger buttonB) {
        new DriveByJoystick(driveTrain, leftJoystick, rightJoystick);
        buttonA.whenActive(new TestCommand(driveTrain));
        buttonB.whenActive(new SecondPathOption(driveTrain));
    }
}
