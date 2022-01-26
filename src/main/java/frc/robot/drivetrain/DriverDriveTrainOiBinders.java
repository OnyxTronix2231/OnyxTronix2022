

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveByDistance;
import frc.robot.drivetrain.commands.DriveBySpeed;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.TestCommand;
import onyxTronix.JoystickAxis;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis leftJoystick, JoystickAxis rightJoystick, Trigger button){
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, leftJoystick::getRawAxis, rightJoystick::getRawAxis));
        button.whenActive(new TestCommand(driveTrain));
    }


}
