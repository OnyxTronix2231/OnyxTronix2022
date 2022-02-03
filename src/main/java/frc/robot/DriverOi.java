package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcDriverOiBinder;
import onyxTronix.JoystickAxis;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withArc(Arc arc) {
        JoystickAxis arcTrigger = new JoystickAxis(xboxController, XboxController.Axis.kLeftY.value);
        new ArcDriverOiBinder(arc, arcTrigger);
        return this;
    }
}
