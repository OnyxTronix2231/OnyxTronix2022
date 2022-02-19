package frc.robot.Conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Conveyor.ballTrigger.commands.PressTrigger;

public class BallTriggerOiBinder {
    public BallTriggerOiBinder(BallTrigger trigger, JoystickButton PressTrigger){
        PressTrigger.whenPressed(new PressTrigger(trigger,()->0.5));
    }
}
