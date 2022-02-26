package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.arc.ArcConstants.ArcCalculations.linearServoPosToAngle;

public class Arc extends SubsystemBase {

    private final ArcComponents components;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents arcComponents) {
        this.components = arcComponents;
        shuffleBoard = new ArcShuffleBoard(this, components);
    }

    @Override
    public void periodic() {
        components.getLinearServo().updateCurrentPosition();
    }

    public double getAngle(){
        return shuffleBoard.getAngle();
    }

    public void setSpeed(double speed) {
        components.getLinearServo().setSpeed(speed);
    }

    public void setPosition(double position) {
        components.getLinearServo().setPosition(position);
    }

    public void stop() {
        components.getLinearServo().setSpeed(0);
    }

    public boolean isOnTarget() {
        return components.getLinearServo().isOnTarget();
    }
}
