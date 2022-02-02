package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.turret.commands.TurretShuffleBoard;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.RobotConstants.*;
import static frc.robot.turret.TurretConstants.calculations.*;

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
        components.getMotor().configForwardSoftLimitThreshold(degToEnc(MAX_DEG));
        components.getMotor().configForwardSoftLimitEnable(true);
        components.getMotor().configReverseSoftLimitThreshold(degToEnc(MIN_DEG));
        components.getMotor().configReverseSoftLimitEnable(true);
    }

    public double getCurrentAngleRTR() {
        return encToDeg(components.getEncoder().getCount());
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void initMoveByDegree(double deg) {
        initMoveToDegree(getCurrentAngleRTR() + deg);
    }

    public void updateMoveByDegree(double deg) {
        updateMoveToDegree(getCurrentAngleRTR() + deg);
    }

    public void initMoveToDegree(double deg) {
        components.getController().setSetpoint(degToEnc(fixDeg(deg)));
        components.getController().enable();
    }

    public void updateMoveToDegree(double deg) {
        components.getController().update(degToEnc(fixDeg(deg)));
    }

    public double fixDeg(double deg) {
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
        return components.getController().isOnTarget(degToEnc(TOLERANCE_DEGREE));
    }

    public TurretComponents getComponents() {
        return components;
    }
}