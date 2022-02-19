package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.LoaderMoveBySpeed;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveTriggerUntilBallInPlace;

import java.util.function.DoubleSupplier;

public class TransferBallsToTrigger extends ParallelCommandGroup {

    public TransferBallsToTrigger(Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                                  DoubleSupplier triggerSpeedSupplier) {
        super(new MoveTriggerUntilBallInPlace(ballTrigger, triggerSpeedSupplier),
                new LoaderMoveBySpeed(loader, loaderSpeedSupplier).
                        deadlineWith(new WaitUntilCommand(() ->
                                ballTrigger.isBallIdentified() && loader.identifiedBall())));
    }
}
