package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.loader.Loader;
import frc.robot.trigger.TriggerOiBinder;
import frc.robot.trigger.TriggerSub;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;


    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }
   /* public DriverOi triggerTest(TriggerSub trigger){
        JoystickButton triggerMoveBySpeed= new JoystickButton(xboxController,XboxController.Button.kA.value);
        new TriggerOiBinder(trigger,triggerMoveBySpeed);
        return this;
    }
    
    */
}
