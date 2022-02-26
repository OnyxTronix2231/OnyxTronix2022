package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arc extends SubsystemBase {

    private final ArcComponents arcComponents;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents arcComponents) {
        this.arcComponents = arcComponents;
        shuffleBoard = new ArcShuffleBoard(this);
        shuffleBoard.init();
    }

    public void setSpeed(double speed) {
        arcComponents.getMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }
}
