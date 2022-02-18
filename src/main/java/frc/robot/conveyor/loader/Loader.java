package frc.robot.conveyor.loader;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.loader.LoaderConstants.IDENTIFIED_BALL_DISTANCE;

public class Loader extends SubsystemBase {

    private final LoaderComponents loaderComponents;
    private boolean lastBallIdentifiedChecked;
    public static int ballCounter = 0;

    public Loader(LoaderComponents components) {
        this.loaderComponents = components;
        lastBallIdentifiedChecked = identifiedBallOnLoader();
    }

    public void moveLoaderBySpeed(double speed) {
        loaderComponents.getMotor().set(speed);
    }

    public void stop() {
        moveLoaderBySpeed(0);
    }

    public boolean identifiedBallBack() {
        return loaderComponents.getBackSensor().getDistance() <= IDENTIFIED_BALL_DISTANCE;
    }

    public boolean identifiedBallFront() {
        return loaderComponents.getFrontSensor().getDistance() <= IDENTIFIED_BALL_DISTANCE;
    }

    public boolean identifiedBallOnLoader() {
        return this.identifiedBallBack() || this.identifiedBallFront();
    }

    public boolean isBallInserted() {
        boolean ballIn = false;
        boolean currentBallIdentifiedCheck = identifiedBallOnLoader();
        if (!lastBallIdentifiedChecked && currentBallIdentifiedCheck) {
            ballIn = true;
        }
        lastBallIdentifiedChecked = currentBallIdentifiedCheck;
        return ballIn;
    }
}
