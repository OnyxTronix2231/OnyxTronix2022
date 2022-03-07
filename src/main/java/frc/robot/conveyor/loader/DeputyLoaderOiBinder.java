package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import static frc.robot.conveyor.loader.LoaderConstants.EJECT_BALLS_LOADER_SPEED;
import static frc.robot.conveyor.loader.LoaderConstants.LOADER_SPEED;

public class DeputyLoaderOiBinder {

    public DeputyLoaderOiBinder(Loader loader, Trigger feedBallTriggerWithBalls, Trigger ejectLoaderBalls) {
        ejectLoaderBalls.whileActiveContinuous(new MoveLoaderBySpeed(loader, () -> EJECT_BALLS_LOADER_SPEED));
        feedBallTriggerWithBalls.whileActiveContinuous(new MoveLoaderBySpeed(loader, () -> LOADER_SPEED));
    }
}
