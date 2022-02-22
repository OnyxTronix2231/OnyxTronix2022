package frc.robot.conveyor.commands;

import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commandsv2.OnyxParallelDeadlineGroup;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class LoadUntilTwoBallsIdentified extends OnyxParallelDeadlineGroup {

    public LoadUntilTwoBallsIdentified(BallTrigger ballTrigger, Loader loader, DoubleSupplier loaderSpeedSupplier) {
        super(() -> ballTrigger.isBallIdentified() && loader.identifiedBall(),
                new MoveLoaderBySpeed(loader, loaderSpeedSupplier));
    }
}
