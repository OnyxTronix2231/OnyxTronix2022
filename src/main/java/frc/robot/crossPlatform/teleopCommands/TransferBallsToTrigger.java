package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Conveyor.loader.Loader;
import frc.robot.Conveyor.loader.commands.LoaderMoveBySpeed;
import frc.robot.Conveyor.ballTrigger.BallTrigger;
import frc.robot.Conveyor.ballTrigger.commands.MoveTriggerUntilBallInPlace;

import java.util.function.DoubleSupplier;

public class TransferBallsToTrigger extends ParallelCommandGroup {

    public TransferBallsToTrigger(Loader loader, BallTrigger trigger, DoubleSupplier loaderSpeedSupplier,
                                  DoubleSupplier triggerSpeedSupplier) {
        super(new MoveTriggerUntilBallInPlace(trigger, triggerSpeedSupplier),
                new LoaderMoveBySpeed(loader, loaderSpeedSupplier).
                        deadlineWith(new WaitUntilCommand(() -> trigger.isHalfLoadedRev() && loader.identifiedBall())));
    }
}