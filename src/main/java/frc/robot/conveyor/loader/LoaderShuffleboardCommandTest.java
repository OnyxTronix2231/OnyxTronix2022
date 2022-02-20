package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.LoaderComponents;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

public class LoaderShuffleboardCommandTest {

    public LoaderShuffleboardCommandTest(Loader loader) {

        var loaderSpeed  = Shuffleboard.getTab("loader").add("loader-speed",
                0.0).getEntry();
        Shuffleboard.getTab("loader").add(new MoveLoaderBySpeed(loader,
                ()->loaderSpeed.getDouble(0)));
        Shuffleboard.getTab("loader").addBoolean("isIdentify",()->loader.identifiedBallBack());
    }
}
