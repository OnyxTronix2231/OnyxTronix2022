package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerUntilBallIdentified;

import java.util.function.DoubleSupplier;

public class TransferBallsToBallTrigger extends ParallelCommandGroup {

    public TransferBallsToBallTrigger(Loader loader, BallTrigger trigger, DoubleSupplier loaderSpeedSupplier,
                                      DoubleSupplier triggerSpeedSupplier) {
        super(new MoveBallTriggerUntilBallIdentified(trigger, triggerSpeedSupplier),
                new MoveLoaderBySpeed(loader, loaderSpeedSupplier).
                        deadlineWith(new WaitUntilCommand(() -> loader.identifiedBallOnLoader())));
    }
}
