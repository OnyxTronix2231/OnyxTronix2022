package frc.robot.conveyor.Loader;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.conveyor.Loader.Loader;
import frc.robot.conveyor.commands.ConveyorLoaderMoveBySpeed;

public class LoaderOiBinder {
    public LoaderOiBinder(Loader loader, JoystickButton loaderMoveBySpeed, JoystickButton triggerMoveBySpeed){
        loaderMoveBySpeed.whileActiveContinuous(new ConveyorLoaderMoveBySpeed(loader, ()->0.3));
    }
}
