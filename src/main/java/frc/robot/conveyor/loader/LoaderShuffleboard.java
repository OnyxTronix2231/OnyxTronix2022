package frc.robot.conveyor.loader;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFY_BALL_MIN;
import static frc.robot.conveyor.loader.LoaderConstants.LOADER_SPEED;

public class LoaderShuffleboard {

    private final Loader loader;
    private NetworkTableEntry minValueEntry;

    public LoaderShuffleboard(Loader loader) {
        this.loader = loader;
    }

    public void init() {
        minValueEntry = Shuffleboard.getTab("Loader").add("MinValue", IDENTIFY_BALL_MIN).getEntry();

        NetworkTableEntry loaderSpeed = Shuffleboard.getTab("Loader").add("LoaderSpeed",
                LOADER_SPEED).getEntry();
        Shuffleboard.getTab("Loader").add(new MoveLoaderBySpeed(loader,
                () -> loaderSpeed.getDouble(LOADER_SPEED)));

        Shuffleboard.getTab("Loader").addBoolean("IsIdentify", loader::identifiedBall);
        Shuffleboard.getTab("Loader").addNumber("DistanceBack", loader::getDistanceBack);
        Shuffleboard.getTab("Loader").addNumber("VoltageBack", loader::getVoltageBack);
        Shuffleboard.getTab("Loader").addNumber("DistanceFront", loader::getDistanceFront);
        Shuffleboard.getTab("Loader").addNumber("VoltageFront", loader::getVoltageFront);
    }

    public double getMinValueEntry() {
        return minValueEntry != null ?
                minValueEntry.getDouble(IDENTIFY_BALL_MIN) : IDENTIFY_BALL_MIN;
    }
}
