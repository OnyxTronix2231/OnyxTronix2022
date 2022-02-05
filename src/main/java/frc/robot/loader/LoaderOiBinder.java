package frc.robot.loader;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.loader.commands.LoaderMoveBySpeed;
import frc.robot.loader.commands.isBallStuck;

public class LoaderOiBinder {
    public LoaderOiBinder(Loader loader, JoystickButton loaderMoveBySpeed,JoystickButton isBallStuck) {
        loaderMoveBySpeed.whileActiveContinuous(new LoaderMoveBySpeed(loader, () -> 0.3));
        isBallStuck.whileActiveContinuous(new isBallStuck(loader,()->-0.3));
    }
}
