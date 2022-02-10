package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.RobotConstants.*;
import static frc.robot.turret.TurretConstants.Calculation.*;

public class Turret extends SubsystemBase {

    private final TurretComponents components;
    private final TurretShuffleBoard turretShuffleBoard;

    public Turret(TurretComponents turretComponents) {
        components = turretComponents;
        configMotorLimits();

        turretShuffleBoard = new TurretShuffleBoard(components);
    }

    @Override
    public void periodic() {
        turretShuffleBoard.update();
    }

    public void configMotorLimits() {
        components.getMotor().configForwardSoftLimitThreshold(degreesToEncoderUnits(MAX_DEG));
        components.getMotor().configForwardSoftLimitEnable(true);
        components.getMotor().configReverseSoftLimitThreshold(degreesToEncoderUnits(MIN_DEG));
        components.getMotor().configReverseSoftLimitEnable(true);
    }

    public double getCurrentAngleRTR() {
        return encoderUnitsToDegrees(components.getEncoder().getPosition());
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void initMoveByDegree(double deg) {
        initMoveToDegreeRTR(getCurrentAngleRTR() + deg);
    }

    public void updateMoveByDegree(double deg) {
        updateMoveToDegreeRTR(getCurrentAngleRTR() + deg);
    }

    public void initMoveToDegreeRTR(double deg) {
        components.getController().setSetpoint(degreesToEncoderUnits(fixAngleAccordingToLimits(deg)));
        components.getController().enable();
    }

    public void updateMoveToDegreeRTR(double deg) {
        components.getController().update(degreesToEncoderUnits(fixAngleAccordingToLimits(deg)));
    }

    public double fixAngleAccordingToLimits(double deg) {
        double fixed = deg % DEG_IN_CIRCLE;
        if (fixed > MAX_DEG) {
            fixed -= DEG_IN_CIRCLE;
        }
        if (fixed < MIN_DEG) {
            fixed += DEG_IN_CIRCLE;
        }
        return fixed;
    }

    public boolean isOnTarget() {
        return components.getController().isOnTarget(degreesToEncoderUnits(TOLERANCE_DEGREES));
    }
}
