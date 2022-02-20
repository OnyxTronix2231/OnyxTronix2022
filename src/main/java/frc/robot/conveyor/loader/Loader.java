package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.loader.LoaderConstants.NO_BALL_DISTANCE;

public class Loader extends SubsystemBase {

    private final LoaderComponents components;

    public Loader(LoaderComponents components) {
        this.components = components;
        new LoaderShuffleboard(this);
    }

    public void moveLoaderBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }

    //TODO replace it for new sensor
    public boolean identifiedBallBack() {
        return components.getBackSensor().getVoltage() >= NO_BALL_DISTANCE && components.getBackSensor().getVoltage() <= 2.5;

    }

    public boolean identifiedBallFront() {
        return components.getFrontSensor().getVoltage() >= NO_BALL_DISTANCE && components.getFrontSensor().getVoltage() <= 2.5;
    }
    /** **/

    public boolean identifiedBall() { //TODO return back check
        return identifiedBallBack() || identifiedBallFront();
    }

    public double getVoltageFront(){
        return components.getFrontSensor().getVoltage();
    }

    public double getVoltageBack(){
        return components.getBackSensor().getVoltage();
    }

    public double getDistanceFront(){
        return components.getFrontSensor().getDistance();
    }

    public double getDistanceBack(){
        return components.getBackSensor().getDistance();
    }
}
