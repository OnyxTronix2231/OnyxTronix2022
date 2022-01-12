package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.drivetrain.DriveTrain;

public class DriveByJoystick extends DriveBySpeed {

    public DriveByJoystick(DriveTrain driveTrain, XboxController joystick) {
        super(joystick::getLeftY, joystick::getRightX, driveTrain);
    }
}
