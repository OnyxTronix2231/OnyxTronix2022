package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.loader.Loader;
import frc.robot.loader.commands.LoadUntilBallIInPlace;
import frc.robot.trigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class LoadBall extends ConditionalCommand {
    public LoadBall(BallTrigger trigger, Loader loader, DoubleSupplier loaderSpeedSupplier,DoubleSupplier triggerSpeedSupplier) {
        super(new LoadUntilBallIInPlace(loader, loaderSpeedSupplier), new TransferBallToTrigger(loader, trigger, loaderSpeedSupplier, triggerSpeedSupplier),
                trigger::isLoadedRev);
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
