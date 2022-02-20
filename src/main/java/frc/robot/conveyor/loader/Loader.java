package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.loader.LoaderConstants.NO_BALL_DISTANCE;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;

    public Loader(LoaderComponents components) {
        this.components = components;
        Shuffleboard.getTab("loader").addNumber("distance", () -> components.getBackSensor().getDistance());
        Shuffleboard.getTab("loader").addNumber("voltage", () -> components.getBackSensor().getVoltage());
    }

    public void moveLoaderBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }

    public boolean identifiedBallBack() {
        return components.getBackSensor().getVoltage() >= 1.7 && components.getBackSensor().getVoltage() <= 2.5;
    }

    public boolean identifiedBallFront() {
        return components.getFrontSensor().getVoltage() >= 1.7 && components.getFrontSensor().getVoltage() <= 2.5;
    }

    public boolean identifiedBall() { //TODO return back check
        return identifiedBallBack();
    }
}
