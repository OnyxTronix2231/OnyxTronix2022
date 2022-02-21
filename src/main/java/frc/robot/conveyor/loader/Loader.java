package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.intake.IntakeShuffleboard;

import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFY_BALL_MAX;
import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFY_BALL_MIN;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;
    private final LoaderShuffleboard loaderShuffleboard;


    public Loader(LoaderComponents components) {
        this.components = components;
        this.loaderShuffleboard = new LoaderShuffleboard(this);
    }

    public void moveLoaderBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }

    //TODO replace it for new sensor
    public boolean identifiedBallBack() {
        return components.getBackSensor().getVoltage() >= loaderShuffleboard.minValueEntry.getDouble(0) &&
                components.getBackSensor().getVoltage() <= loaderShuffleboard.maxValueEntry.getDouble(0);

    }

    public boolean identifiedBallFront() {
        return components.getFrontSensor().getVoltage() >= loaderShuffleboard.minValueEntry.getDouble(0) &&
                components.getFrontSensor().getVoltage() <= loaderShuffleboard.maxValueEntry.getDouble(0);
    }

    /**
     *
     **/

    public boolean identifiedBall() { //TODO return back check
        return identifiedBallBack() || identifiedBallFront();
    }

    public double getVoltageFront() {
        return components.getFrontSensor().getVoltage();
    }

    public double getVoltageBack() {
        return components.getBackSensor().getVoltage();
    }

    public double getDistanceFront() {
        return components.getFrontSensor().getDistance();
    }

    public double getDistanceBack() {
        return components.getBackSensor().getDistance();
    }
}
