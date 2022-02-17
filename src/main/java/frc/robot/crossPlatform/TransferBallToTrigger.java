package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.loader.Loader;
import frc.robot.loader.commands.LoaderMoveBySpeed;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.MoveTriggerUntilBallInPlace;

import java.util.function.DoubleSupplier;

public class TransferBallToTrigger extends ParallelCommandGroup {

    public TransferBallToTrigger(Loader loader, BallTrigger trigger, DoubleSupplier loaderSpeedSupplier,
                                 DoubleSupplier triggerSpeedSupplier) {
        super(new MoveTriggerUntilBallInPlace(trigger, triggerSpeedSupplier),
                new LoaderMoveBySpeed(loader, loaderSpeedSupplier).
                        deadlineWith(new WaitUntilCommand(() -> trigger.isHalfLoadedRev() && loader.identifiedBall())));
    }
}
