package frc.robot.conveyor.loader.commands;

import frc.robot.conveyor.commands.OnyxParallelDeadlineGroup;
import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class LoadUntilBallIInPlace extends OnyxParallelDeadlineGroup {

    public LoadUntilBallIInPlace(Loader loader, DoubleSupplier speedSupplier) {
        super(loader::identifiedBall, new MoveLoaderBySpeed(loader, speedSupplier));
    }
}
