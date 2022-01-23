

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveByDistance;
import frc.robot.drivetrain.commands.DriveBySpeed;
import frc.robot.drivetrain.commands.MoveByPath;
import onyxTronix.JoystickAxis;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.ONE_METER_FORWARD;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis rightJoystick, JoystickAxis leftJoystick, Trigger button){
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, rightJoystick::getRawAxis, leftJoystick::getRawAxis));
        button.whenActive(new MoveByPath(driveTrain, ONE_METER_FORWARD));
    }


}
