package frc.robot.drivetrain;

import frc.robot.drivetrain.commands.DriveByJoystick;
import humanControls.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis leftJoystick, JoystickAxis rightJoystick) {
        new DriveByJoystick(driveTrain, leftJoystick, rightJoystick);
    }
}
