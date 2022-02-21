package frc.robot.conveyor.loader;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFY_BALL_MAX;
import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFY_BALL_MIN;

public class LoaderShuffleboard {

    NetworkTableEntry minValueEntry;
    NetworkTableEntry maxValueEntry;


    public LoaderShuffleboard(Loader loader) {

        minValueEntry = Shuffleboard.getTab("Loader").add("MinValue", IDENTIFY_BALL_MIN).getEntry();

        maxValueEntry = Shuffleboard.getTab("Loader").add("MaxValue", IDENTIFY_BALL_MAX).getEntry();

        var loaderSpeed = Shuffleboard.getTab("Loader").add("LoaderSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("Loader").add(new MoveLoaderBySpeed(loader,
                () -> loaderSpeed.getDouble(0)));

        Shuffleboard.getTab("Loader").addBoolean("IsIdentify", loader::identifiedBall);
        Shuffleboard.getTab("Loader").addNumber("DistanceBack", loader::getDistanceBack);
        Shuffleboard.getTab("Loader").addNumber("VoltageBack", loader::getVoltageBack);
        Shuffleboard.getTab("Loader").addNumber("DistanceFront", loader::getDistanceFront);
        Shuffleboard.getTab("Loader").addNumber("VoltageFront", loader::getVoltageFront);
    }

    public double getMinValueEntry() {
        return minValueEntry.getDouble(IDENTIFY_BALL_MIN);
    }

    public double getMaxValueEntry() {
        return maxValueEntry.getDouble(IDENTIFY_BALL_MAX);
    }
}