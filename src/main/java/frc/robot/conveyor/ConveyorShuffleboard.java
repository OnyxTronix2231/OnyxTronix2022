package frc.robot.conveyor;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;

public class ConveyorShuffleboard {
    public ConveyorShuffleboard(Loader loader, BallTrigger ballTrigger) {

        var loaderSpeed = Shuffleboard.getTab("Conveyor").add("LoaderSpeed",
                0.0).getEntry();
        var ballTriggerSpeed = Shuffleboard.getTab("Conveyor").add("BallTriggerSpeed",
                0.0).getEntry();

        Shuffleboard.getTab("Conveyor").add(new LoadBalls(loader,ballTrigger,
                ()->loaderSpeed.getDouble(0),
                ()->ballTriggerSpeed.getDouble(0)));

    }
}
