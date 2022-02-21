package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

public class LoaderOiBinder {

    public LoaderOiBinder(Loader loader, Trigger trigger) {
        trigger.whileActiveContinuous(new MoveLoaderBySpeed(loader, ()->0.5));
    }
}
