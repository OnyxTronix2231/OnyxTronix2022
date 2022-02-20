package frc.robot.conveyor.loader;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import static frc.robot.conveyor.loader.LoaderConstants.NO_BALL_DISTANCE;

public class LoaderShuffleboard {

    NetworkTableEntry minValueEntry;
    public LoaderShuffleboard(Loader loader) {

        var loaderSpeed  = Shuffleboard.getTab("loader").add("loader-speed",
                0.0).getEntry();
        Shuffleboard.getTab("loader").add(new MoveLoaderBySpeed(loader,
                ()->loaderSpeed.getDouble(0)));

        Shuffleboard.getTab("loader").addBoolean("isIdentify", loader::identifiedBallBack);
        Shuffleboard.getTab("loader").addNumber("distanceBack", loader::getDistanceBack);
        Shuffleboard.getTab("loader").addNumber("voltageBack", loader::getVoltageBack);
        Shuffleboard.getTab("loader").addNumber("distanceFront", loader::getDistanceFront);
        Shuffleboard.getTab("loader").addNumber("voltageFront", loader::getVoltageFront);

         minValueEntry = Shuffleboard.getTab("loader").add("minValue",
                0.0).getEntry();
         Shuffleboard.getTab("loader").addNumber("min-val", this::getMinValueEntry);

    }

    public double getMinValueEntry(){
        return minValueEntry.getDouble(NO_BALL_DISTANCE);
    }
}
