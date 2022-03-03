package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import static frc.robot.conveyor.loader.LoaderConstants.LOADER_SPEED;

public class TestLoaderOiBinder {

    public TestLoaderOiBinder(Loader loader, Trigger trigger) {
        trigger.whileActiveContinuous(new MoveLoaderBySpeed(loader, () -> LOADER_SPEED));
    }
}
