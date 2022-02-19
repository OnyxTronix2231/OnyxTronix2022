package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.conveyor.ballTrigger.commands.PressTrigger;

public class BallTriggerOiBinder {
    public BallTriggerOiBinder(BallTrigger trigger, JoystickButton PressTrigger){
        PressTrigger.whenPressed(new PressTrigger(trigger,()->0.5));
    }
}
