package frc.robot.conveyor.commands;

import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class LoadUntillTwoBalls extends OnyxParallelDeadlineGroup {
    public LoadUntillTwoBalls(Loader loader, BallTrigger ballTrigger, DoubleSupplier speedSupplier) {
        super(() -> loader.identifiedBall() && ballTrigger.isBallIdentified(),
                new MoveLoaderBySpeed(loader, speedSupplier));
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            end(false);
            initialize();
        }
        return false;
    }
}
