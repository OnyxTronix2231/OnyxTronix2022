package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.loader.Loader;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }
    public DriverOi woodTest(Loader conveyor){
        JoystickButton triggerMoveBySpeed= new JoystickButton(xboxController,XboxController.Button.kA.value);
        JoystickButton loaderMoveBySpeed= new JoystickButton(xboxController,XboxController.Button.kA.value);
        return this;
    }
}
