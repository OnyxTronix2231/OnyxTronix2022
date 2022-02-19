package frc.robot.Conveyor.loader;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Conveyor.loader.commands.LoaderMoveBySpeed;

public class LoaderOiBinder {
    public LoaderOiBinder(Loader loader, JoystickButton loaderMoveBySpeed) {
        loaderMoveBySpeed.whileActiveContinuous(new LoaderMoveBySpeed(loader, () -> 0.3));
    }
}
