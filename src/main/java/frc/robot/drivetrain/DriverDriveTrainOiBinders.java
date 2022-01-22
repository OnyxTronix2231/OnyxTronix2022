

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveByDistance;
import frc.robot.drivetrain.commands.DriveBySpeed;
import onyxTronix.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis rightJoystick, JoystickAxis leftJoystick, Trigger button){
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, rightJoystick::getRawAxis, leftJoystick::getRawAxis));
        button.whenActive(new DriveByDistance(driveTrain, ()-> 1.0));
    }


}
