package frc.robot.conveyor;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commandsv2.LoadBallsV2;
import frc.robot.conveyor.loader.Loader;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.BALLTRIGGER_SPEED;
import static frc.robot.conveyor.loader.LoaderConstants.LOADER_SPEED;

public class ConveyorShuffleboard {
    public ConveyorShuffleboard(Loader loader, BallTrigger ballTrigger) {

        var loaderSpeed = Shuffleboard.getTab("Conveyor").add("LoaderSpeed",
                0).getEntry();
        var ballTriggerSpeed = Shuffleboard.getTab("Conveyor").add("BallTriggerSpeed",
                0).getEntry();

        Shuffleboard.getTab("Conveyor").add(new LoadBallsV2(loader, ballTrigger,
                () -> loaderSpeed.getDouble(LOADER_SPEED),
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_SPEED)));
    }
}
