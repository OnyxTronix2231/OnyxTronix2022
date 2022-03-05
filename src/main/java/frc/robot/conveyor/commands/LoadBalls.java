package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class LoadBalls extends ParallelCommandGroup {

    public LoadBalls(Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                     DoubleSupplier ballTriggerSpeedSupplier) {
        super(//new LoadUntilTwoBalls(loader, ballTrigger, loaderSpeedSupplier),
                //new MoveBallTriggerUntilBallInPlace(ballTrigger, ballTriggerSpeedSupplier)
                new MoveLoaderBySpeed(loader, loaderSpeedSupplier));
    }
}
