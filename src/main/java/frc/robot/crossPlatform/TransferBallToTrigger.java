package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.loader.Loader;
import frc.robot.loader.commands.LoaderMoveBySpeed;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.MoveTriggerUntilBallInPlace;

import java.util.function.DoubleSupplier;

public class TransferBallToTrigger extends ParallelDeadlineGroup {

    public TransferBallToTrigger(Loader loader, BallTrigger trigger, DoubleSupplier loaderSpeedSupplier, DoubleSupplier triggerSpeedSupplier) {
        super(new MoveTriggerUntilBallInPlace(trigger, triggerSpeedSupplier), new LoaderMoveBySpeed(loader, loaderSpeedSupplier));
    } // TODO What if 2 balls are in at the same time.
}
