package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerUntilBallInPlace;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class TransferBallsToTrigger extends ParallelCommandGroup {

    public TransferBallsToTrigger(Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                                  DoubleSupplier triggerSpeedSupplier) {
        super(new MoveLoaderBySpeed(loader, loaderSpeedSupplier).
                deadlineWith(new WaitUntilTwoBallsIdentified(loader, ballTrigger).
                        deadlineWith(new MoveBallTriggerUntilBallInPlace(ballTrigger, triggerSpeedSupplier))));
    }
}
