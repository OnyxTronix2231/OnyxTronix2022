package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.loader.Loader;
import frc.robot.loader.commands.LoaderMoveBySpeed;
import frc.robot.trigger.BallTrigger;
import frc.robot.trigger.commands.MoveTriggerUntilBallIdentified;

import java.util.function.DoubleSupplier;

public class TransferBallToTrigger extends ParallelDeadlineGroup {

    public TransferBallToTrigger(Loader loader, BallTrigger trigger, DoubleSupplier loaderSpeedSupplier, DoubleSupplier triggerSpeedSupplier) {
        super (new MoveTriggerUntilBallIdentified(trigger, triggerSpeedSupplier),
                new LoaderMoveBySpeed(loader, loaderSpeedSupplier));
    }
}
