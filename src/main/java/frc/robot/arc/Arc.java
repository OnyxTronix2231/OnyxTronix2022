package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.arc.ArcConstants.ArcCalculations.angleToEncoderUnits;

public class Arc extends SubsystemBase {

    private final ArcComponents arcComponents;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents arcComponents) {
        this.arcComponents = arcComponents;
        shuffleBoard = new ArcShuffleBoard(this);
        shuffleBoard.init();
    }

    public void setPID(double kP, double kI, double kD, double kF) {
        arcComponents.getController().setPIDFTerms(kP, kI, kD, kF);
    }

    public void initMoveToAngle(double angle) {
        arcComponents.getController().setSetpoint(angleToEncoderUnits(angle));
        arcComponents.getController().enable();
    }

    public void updateMoveToAngle(double angle) {
        arcComponents.getController().update(angleToEncoderUnits(angle));
    }

    public void setSpeed(double speed) {
        arcComponents.getMotor().set(speed);
    }

    public boolean hasHitReverseLimit(){
        return arcComponents.getReverseMicroSwitch().isOpen();
    }

    public void stop() {
        setSpeed(0);
    }
}
