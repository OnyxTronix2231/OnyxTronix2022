package frc.robot.conveyor.loader.commands;

import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class LoadUntilBallIdentified extends MoveLoaderBySpeed {

    private final Loader loader;

    public LoadUntilBallIdentified(Loader loader, DoubleSupplier speedSupplier) {
        super(loader, speedSupplier);
        this.loader = loader;
    }

    @Override
    public boolean isFinished() {
        return loader.identifiedBallOnLoader();
    }
}
