package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.Conveyor.loader.Loader;
import frc.robot.Conveyor.loader.commands.LoadUntilBallIInPlace;
import frc.robot.Conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class LoadBalls extends ConditionalCommand {
    public LoadBalls(BallTrigger trigger, Loader loader, DoubleSupplier loaderSpeedSupplier,
                     DoubleSupplier triggerSpeedSupplier) {
        super(new LoadUntilBallIInPlace(loader, loaderSpeedSupplier),
                new TransferBallsToTrigger(loader, trigger, loaderSpeedSupplier, triggerSpeedSupplier),
                trigger::isLoadedRev);
    }
}
