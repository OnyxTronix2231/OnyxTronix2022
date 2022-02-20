package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerUntilBallInPlace;
import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class TransferBallsToTrigger extends ParallelCommandGroup {

    public TransferBallsToTrigger(Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                                  DoubleSupplier triggerSpeedSupplier) {
        super(new MoveBallTriggerUntilBallInPlace(ballTrigger, triggerSpeedSupplier).
                deadlineWith(new LoadUntilTwoBallsIdentified(ballTrigger, loader, loaderSpeedSupplier)));
    }
}
