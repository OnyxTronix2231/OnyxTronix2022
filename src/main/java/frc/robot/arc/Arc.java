package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arc extends SubsystemBase {

    private final ArcComponents components;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents arcComponents) {
        this.components = arcComponents;
        shuffleBoard = new ArcShuffleBoard(this);
        shuffleBoard.init();
    }

    @Override
    public void periodic() {
        components.getLinearServo().updateCurrentPosition();
    }

    public void setSpeed(double speed) {
        components.getLinearServo().setSpeed(speed);
    }

    public void setPosition(double position) {
        components.getLinearServo().setPosition(position);
    }

    public double getCurrentPos() {
        return components.getLinearServo().getPosition();
    }

    public void stop() {
        components.getLinearServo().setSpeed(0);
    }
}
