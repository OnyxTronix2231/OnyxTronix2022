package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.shooter.ShooterConstants;

import static frc.robot.arc.ArcConstants.ArcCalculations.*;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MAX_ANGLE;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;
import static frc.robot.arc.ArcConstants.TOLERANCE;

public class Arc extends SubsystemBase {

    private final ArcComponents components;
    //private final ArcShuffleBoard shuffleBoard;

    public Arc(ArcComponents components) {
        this.components = components;
        //shuffleBoard = new ArcShuffleBoard(this);
        components.getMotor().configForwardSoftLimitThreshold(angleToEncoderUnits(ARC_MAX_ANGLE));
        components.getMotor().configReverseSoftLimitThreshold(angleToEncoderUnits(ARC_MIN_ANGLE));
        enableSoftLimitSwitch(true);
        resetEncoderByAbsoluteValue();
    }

    @Override
    public void periodic() {
        //shuffleBoard.update();
    }

    public void initMoveToAngle(double angle) {
        components.getController().setSetpoint(angleToEncoderUnits(angle));
        components.getController().enable();
    }

    public double getSetpoint(){
        return angleToEncoderUnits(components.getController().getSetpoint());
    }

    public void updateMoveToAngle(double angle) {
        components.getController().update(angleToEncoderUnits(angle));
    }

    public void initMoveArcByDistance(double distance) {
        initMoveToAngle(distanceToAngle(distance));
    }

    public void updateMoveArcByDistance(double distance) {
        updateMoveToAngle(distanceToAngle(distance));
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean hasHitReverseMicroSwitch() {
        return ! components.getReverseMicroSwitch().isOpen();
    }

    public void resetEncoderByAbsoluteValue() {
        components.getMotor().setSelectedSensorPosition(angleToEncoderUnits(ARC_MIN_ANGLE));
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public ArcComponents getComponents() {
        return components;
    }

    public void enableSoftLimitSwitch(boolean enable) {
        components.getMotor().configForwardSoftLimitEnable(enable);
        components.getMotor().configReverseSoftLimitEnable(enable);
    }

    public double getCurrentAngle(){
        return encoderUnitsToAngle(components.getCounter().getCount());
    }

    public boolean isOnTarget() {
        return components.getController().isOnTarget(angleToEncoderUnits(TOLERANCE));
    }
}
