package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;
    private final LoaderShuffleboard loaderShuffleboard;

    public Loader(LoaderComponents components) {
        this.components = components;
        this.loaderShuffleboard = new LoaderShuffleboard(this);
//        loaderShuffleboard.init();
    }

    public void moveLoaderBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
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

    public boolean identifiedBallFront() {
        return getVoltageFront() >= loaderShuffleboard.getMinValueEntry();
    }

    public boolean identifiedBallBack() {
        return getVoltageBack() >= loaderShuffleboard.getMinValueEntry();
    }

    public boolean identifiedBall() {
        return identifiedBallBack() || identifiedBallFront();
    }
}
