package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveBySpeed;
import frc.robot.drivetrain.commands.pathCommands.TestCommand;
import humanControls.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis leftJoystick, JoystickAxis rightJoystick, Trigger buttonA, Trigger buttonB) {
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, leftJoystick::getRawAxis, rightJoystick::getRawAxis));
        buttonA.whenActive(new TestCommand(driveTrain));
    }
}
