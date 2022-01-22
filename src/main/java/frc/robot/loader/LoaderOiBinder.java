package frc.robot.loader;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.loader.commands.LoaderMoveBySpeed;

public class LoaderOiBinder {
    public LoaderOiBinder(Loader conveyor, JoystickButton loaderMoveBySpeed){
        loaderMoveBySpeed.whileActiveContinuous(new LoaderMoveBySpeed(conveyor,()->0.3));
    }
}
