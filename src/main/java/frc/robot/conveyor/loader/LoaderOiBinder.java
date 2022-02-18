package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

public class LoaderOiBinder {
    public LoaderOiBinder(Loader loader, JoystickButton loaderMoveBySpeed) {
        loaderMoveBySpeed.whileActiveContinuous(new MoveLoaderBySpeed(loader, () -> 0.3));
    }
}
