package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
<<<<<<< HEAD
import frc.robot.trigger.TriggerOiBinder;
import frc.robot.trigger.Triggerr;
=======
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.trigger.TriggerOiBinder;
import frc.robot.trigger.TriggerSub;
import onyxTronix.JoystickAxis;
>>>>>>> 42a9833bd240527147887e07d1aee86bb437a999

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

<<<<<<< HEAD
    public DriverOi triggerTest(Triggerr trigger) {
=======
    public DriverOi withDriveTrain(DriveTrain driveTrain) {
        JoystickAxis leftJoystick = new JoystickAxis(xboxController, XboxController.Axis.kLeftY.value);
        JoystickAxis rightJoystick = new JoystickAxis(xboxController, XboxController.Axis.kRightX.value);
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi triggerTest(TriggerSub trigger) {
>>>>>>> 42a9833bd240527147887e07d1aee86bb437a999
        JoystickButton triggerMoveBySpeed = new JoystickButton(xboxController, XboxController.Button.kA.value);
        new TriggerOiBinder(trigger, triggerMoveBySpeed);
        return this;
    }
<<<<<<< HEAD

=======
>>>>>>> 42a9833bd240527147887e07d1aee86bb437a999
}
