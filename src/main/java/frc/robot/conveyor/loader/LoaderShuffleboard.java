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

        var loaderSpeed = Shuffleboard.getTab("loader").add("loader-speed",
                0.0).getEntry();
        Shuffleboard.getTab("loader").add(new MoveLoaderBySpeed(loader,
                () -> loaderSpeed.getDouble(0)));

        Shuffleboard.getTab("loader").addBoolean("isIdentify", loader::identifiedBallBack);
        Shuffleboard.getTab("loader").addNumber("distanceBack", loader::getDistanceBack);
        Shuffleboard.getTab("loader").addNumber("voltageBack", loader::getVoltageBack);
        Shuffleboard.getTab("loader").addNumber("distanceFront", loader::getDistanceFront);
        Shuffleboard.getTab("loader").addNumber("voltageFront", loader::getVoltageFront);

        minValueEntry = Shuffleboard.getTab("loader").add("minValue", 0.0).getEntry();
        Shuffleboard.getTab("loader").addNumber("min-val", this::getMinValueEntry);

        maxValueEntry = Shuffleboard.getTab("loader").add("maxValue", 0.0).getEntry();
        Shuffleboard.getTab("loader").addNumber("max-val", this::getMinValueEntry);


    }

    public double getMinValueEntry() {
        return minValueEntry.getDouble(IDENTIFY_BALL_MIN);
    }

    public double getMaxValueEntry() {
        return maxValueEntry.getDouble(IDENTIFY_BALL_MAX);
    }
}
