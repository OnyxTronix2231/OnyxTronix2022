package frc.robot.drivetrain;

import frc.robot.drivetrain.commands.DriveBySpeed;
import humanControls.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis leftJoystick, JoystickAxis rightJoystick) {
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, () -> leftJoystick.getRawAxis(),
                rightJoystick::getRawAxis));
    }
}
