package frc.robot.conveyor.commands;

import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.LoadUntilBallIInPlace;

import java.util.function.DoubleSupplier;

public class LoadUntilBallShot extends OnyxParallelDeadlineGroup {

    public LoadUntilBallShot(BallTrigger ballTrigger, Loader loader, DoubleSupplier speedSupplier) {
        super(() -> !ballTrigger.isBallInPlace(), new LoadUntilBallIInPlace(loader, speedSupplier));
    }
}
