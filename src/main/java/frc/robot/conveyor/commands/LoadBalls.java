package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class LoadBalls extends ConditionalCommand {

    public LoadBalls(Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                     DoubleSupplier triggerSpeedSupplier) {
        super(new LoadUntilBallShot(ballTrigger, loader, loaderSpeedSupplier),
                new TransferBallsToTrigger(loader, ballTrigger, loaderSpeedSupplier, triggerSpeedSupplier),
                ballTrigger::isBallInPlace);
    }
}
