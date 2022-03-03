package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.arc.ArcConstants.ArcCalculations.angleToEncoderUnits;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MAX_ANGLE;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;
import static frc.robot.arc.ArcConstants.TIME_OUT;

public class Arc extends SubsystemBase {

    private final ArcComponents components;
    private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents components) {
        this.components = components;
        shuffleBoard = new ArcShuffleBoard(this);
        components.getMotor().configForwardSoftLimitThreshold(angleToEncoderUnits(ARC_MAX_ANGLE));
        components.getMotor().configForwardSoftLimitEnable(true);
        components.getMotor().configReverseSoftLimitThreshold(angleToEncoderUnits(ARC_MIN_ANGLE));
        components.getMotor().configReverseSoftLimitEnable(true);

        resetEncoderByAbsoluteValue();
    }

    @Override
    public void periodic() {
        shuffleBoard.update();
    }

    public void initMoveToAngle(double angle) {
        components.getController().setSetpoint(angleToEncoderUnits(angle));
        components.getController().enable();
    }

    public void updateMoveToAngle(double angle) {
        components.getController().update(angleToEncoderUnits(angle));
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean hasHitReverseMicroSwitch() {
        return components.getReverseMicroSwitch().isOpen();
    }

    public void resetEncoderByAbsoluteValue() {
        components.getMotor().getSensorCollection().setPulseWidthPosition(0, TIME_OUT);
        components.getMotor().setSelectedSensorPosition(0);
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public ArcComponents getComponents(){
        return components;
    }
}
