package frc.robot.conveyor.loader;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TronixLogger.Logging.OnyxLogger;

public class Loader extends SubsystemBase implements Sendable {

    private final LoaderComponents components;
    private final LoaderShuffleboard loaderShuffleboard;

    public Loader(LoaderComponents components) {
        this.components = components;
        this.loaderShuffleboard = new LoaderShuffleboard(this);
        OnyxLogger.getInstance().addBooleanListener("loader is", this::identifiedBall,1000);
        loaderShuffleboard.init();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("nimi");
        builder.addDoubleProperty("test", this::getVoltageBack, null);
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
