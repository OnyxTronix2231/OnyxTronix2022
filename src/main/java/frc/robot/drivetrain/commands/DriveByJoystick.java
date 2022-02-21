package frc.robot.drivetrain.commands;

import frc.robot.drivetrain.DriveTrain;
import humanControls.JoystickAxis;

public class DriveByJoystick {

    public DriveByJoystick(DriveTrain driveTrain, JoystickAxis leftDriveJoystick, JoystickAxis rightDriveJoystick) {
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, () -> -leftDriveJoystick.getRawAxis(),
                rightDriveJoystick::getRawAxis));
    }
}
