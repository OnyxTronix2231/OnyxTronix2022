package frc.robot.conveyor;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;

import static frc.robot.conveyor.ConveyorConstant.BALLTRIGGER_CONVEYOR_SPEED;
import static frc.robot.conveyor.ConveyorConstant.LOADER_CONVEYOR_SPEED;

public class ConveyorShuffleboard {

    private final Loader loader;
    private final BallTrigger ballTrigger;

    public ConveyorShuffleboard(Loader loader, BallTrigger ballTrigger) {
        this.loader = loader;
        this.ballTrigger = ballTrigger;
    }

    public void init() {
        NetworkTableEntry loaderSpeed = Shuffleboard.getTab("Conveyor").add("LoaderSpeed",
                LOADER_CONVEYOR_SPEED).getEntry();
        NetworkTableEntry ballTriggerSpeed = Shuffleboard.getTab("Conveyor").add("BallTriggerSpeed",
                BALLTRIGGER_CONVEYOR_SPEED).getEntry();

        Shuffleboard.getTab("Conveyor").add(new LoadBalls(loader, ballTrigger,
                () -> loaderSpeed.getDouble(LOADER_CONVEYOR_SPEED),
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_CONVEYOR_SPEED)));
    }
}
