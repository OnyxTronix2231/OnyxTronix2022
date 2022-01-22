package frc.robot.conveyor;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.conveyor.commands.ConveyorLoaderMoveBySpeed;

public class ConveyorOiBinder {
    public ConveyorOiBinder(Conveyor conveyor, JoystickButton loaderMoveBySpeed,JoystickButton triggerMoveBySpeed){
        loaderMoveBySpeed.whileActiveContinuous(new ConveyorLoaderMoveBySpeed(conveyor,()->0.3));
        triggerMoveBySpeed.whileActiveContinuous(new ConveyorLoaderMoveBySpeed(conveyor,()->0.3));
    }
}
