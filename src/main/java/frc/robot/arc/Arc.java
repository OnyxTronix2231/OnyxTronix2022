package frc.robot.arc;

import static frc.robot.arc.ArcConstents.*;

public class Arc {
    private ArcComponents arcComponents;

    public Arc(ArcComponents arcComponents){

        this.arcComponents = arcComponents;

        arcComponents.getMotor().configForwardSoftLimitEnable(true);
        arcComponents.getMotor().configForwardSoftLimitThreshold(angleToEncoderUnits(MAX_POSSIBLE_ANGLE));
        arcComponents.getMotor().configReverseSoftLimitEnable(true);
        arcComponents.getMotor().configReverseSoftLimitThreshold(angleToEncoderUnits(MIN_POSSIBLE_ANGLE));

        resetEncoderByAbsoluteValue();
    }

    public void moveBySpeed(double speed) {
        arcComponents.getMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
        arcComponents.getController().disable();
    }

    public void initMoveToAngle(double angle) {
        angle = getValidAngle(angle);
        arcComponents.getController().setSetpoint(angleToEncoderUnits(angle));
        arcComponents.getController().enable();
    }

    public void updateMoveToAngle(double angle) {
        angle = getValidAngle(angle);
        arcComponents.getController().update(angleToEncoderUnits(angle));
    }

    public void configReverseSoftLimitEnable(boolean enable) {
        arcComponents.getMotor().configReverseSoftLimitEnable(enable);
    }

    public double distanceMetersToAngle(double distance) {
        return Math.min(ArcCalculation.FORMULA_DISTANCE_FAR(distance), REAL_MAX_POSSIBLE_ANGLE);
    }

    public double angleToEncoderUnits(double angle) {
        return (angle / ANGLE_PER_MOTOR_ROTATION) * ENCODER_UNITS_PER_ROTATION;
    }

    public double encoderUnitsToAngle(double encoderUnits) {
        return (encoderUnits / ENCODER_UNITS_PER_ROTATION) * ANGLE_PER_MOTOR_ROTATION;
    }

    public double getValidAngle(double angle) {
        angle = angle - OFFSET;
        return Math.min(MAX_POSSIBLE_ANGLE, Math.max(angle, MIN_POSSIBLE_ANGLE));
    }

    public double getAngle() {
        return encoderUnitsToAngle(arcComponents.getCounter().getCount()) + OFFSET;
    }

    public boolean isOnTarget() {
        return arcComponents.getController().isOnTarget(angleToEncoderUnits(TOLERANCE_ANGLE));
    }

    public boolean hasHitForwardLimit() {
        return arcComponents.getForwardLimitSwitch().isOpen();
    }

    public boolean hasHitReverseLimit() {
        return arcComponents.getReverseLimitSwitch().isOpen();
    }

    public void resetEncoderByAbsoluteValue() {
        arcComponents.getMotor().getSensorCollection().setPulseWidthPosition(0, TIME_OUT);
        arcComponents.getMotor().setSelectedSensorPosition(0);
    }
}
