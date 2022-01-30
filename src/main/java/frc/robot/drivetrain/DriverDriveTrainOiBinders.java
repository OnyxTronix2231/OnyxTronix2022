

package frc.robot.drivetrain;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveBySpeed;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.drivetrain.commands.TestCommand;
import onyxTronix.JoystickAxis;

public class DriverDriveTrainOiBinders {

    public DriverDriveTrainOiBinders(DriveTrain driveTrain, JoystickAxis rightJoystick, JoystickAxis leftJoystick, Trigger buttonA, Trigger buttonB){
        driveTrain.setDefaultCommand(new DriveBySpeed(driveTrain, rightJoystick::getRawAxis, leftJoystick::getRawAxis));
        buttonA.whenActive(new TestCommand(driveTrain));
        buttonB.whenActive(new ResetOdometryToPose(driveTrain, new Translation2d(2, 2)));
    }
}
