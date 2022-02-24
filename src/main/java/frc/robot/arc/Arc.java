package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.arc.ArcConstants.ArcCalculations.linearServoPosToAngle;

public class Arc extends SubsystemBase {

    private final ArcComponents arcComponents;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents arcComponents) {
        this.arcComponents = arcComponents;
        shuffleBoard = new ArcShuffleBoard(this, arcComponents);
    }

    @Override
    public void periodic() {
        arcComponents.getLinearServo().updateCurrentPosition();
    }

    public double getAngle(){
        return shuffleBoard.getAngle();
    }

    public void setSpeed(double speed) {
        arcComponents.getLinearServo().setSpeed(speed);
    }

    public void setPosition(double position) {
        arcComponents.getLinearServo().setPosition(position);
    }

    public void stop() {
        arcComponents.getLinearServo().setSpeed(0);
    }

    public boolean isOnTarget() {
        return arcComponents.getLinearServo().isOnTarget();
    }

}
