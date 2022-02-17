package frc.robot.trigger;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.trigger.commands.PressTrigger;
import frc.robot.trigger.commands.TriggerMoveBySpeed;

public class BallTriggerOiBinder {
    public BallTriggerOiBinder(BallTrigger trigger, JoystickButton PressTrigger){
        PressTrigger.whenPressed(new PressTrigger(trigger,()->0.5));
    }
}
