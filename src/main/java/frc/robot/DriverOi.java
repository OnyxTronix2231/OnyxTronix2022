package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcDriverOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.shooter.Shooter;
import onyxTronix.JoystickAxis;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withDriveTrain(DriveTrain driveTrain) {
        JoystickAxis leftJoystick = new JoystickAxis(xboxController, XboxController.Axis.kLeftY.value);
        JoystickAxis rightJoystick = new JoystickAxis(xboxController, XboxController.Axis.kRightX.value);
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi withArc(Arc arc) {
        JoystickAxis arcTrigger = new JoystickAxis(xboxController, XboxController.Axis.kLeftY.value);
        new ArcDriverOiBinder(arc, arcTrigger);
        return this;
    }
}
