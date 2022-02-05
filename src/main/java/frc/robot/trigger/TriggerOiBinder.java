package frc.robot.trigger;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.trigger.commands.TriggerMoveBySpeed;

public class TriggerOiBinder {
    public TriggerOiBinder(Triggerr trigger, JoystickButton triggerMoveBySpeed){
        triggerMoveBySpeed.whenPressed(new TriggerMoveBySpeed(trigger,()->0.3));
    }
}
