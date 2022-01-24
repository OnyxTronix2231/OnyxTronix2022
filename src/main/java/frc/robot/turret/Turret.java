package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.turret.TurretConstants.*;

public class Turret extends SubsystemBase {

    private final TurretComponents components;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;

    public Turret(TurretComponents turretComponents) {
        components = turretComponents;
        configMotorLimits();

        Shuffleboard.getTab("Turret").addNumber("number", this::getCurrentAngle);
        kP = Shuffleboard.getTab("Turret").add("set kP",
                components.getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Turret").add("set kI",
                components.getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Turret").add("set kD",
                components.getController().getPIDFTerms().getKd()).getEntry();
        kF = Shuffleboard.getTab("Turret").add("set kF",
                components.getController().getPIDFTerms().getKf()).getEntry();
    }

    @Override
    public void periodic() {
        components.getController().setPIDFTerms(
                kP.getDouble(components.getController().getPIDFTerms().getKp()),
                kI.getDouble(components.getController().getPIDFTerms().getKi()),
                kD.getDouble(components.getController().getPIDFTerms().getKd()),
                kF.getDouble(components.getController().getPIDFTerms().getKf()));
    }

    public void configMotorLimits() {
        components.getMotor().configForwardSoftLimitThreshold(degToEnc(MAX_DEG));
        components.getMotor().configForwardSoftLimitEnable(true);
        components.getMotor().configReverseSoftLimitThreshold(degToEnc(MIN_DEG));
        components.getMotor().configReverseSoftLimitEnable(true);
    }

    public double getCurrentAngle() {
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
        initMoveToDegree(getCurrentAngle() + deg);
    }

    public void updateMoveByDegree(double deg) {
        updateMoveToDegree(getCurrentAngle() + deg);
    }

    public void initMoveToDegree(double deg) {
        components.getController().setSetpoint(degToEnc(fixDeg(deg)));
        components.getController().enable();
    }

    public void updateMoveToDegree(double deg) {
        components.getController().update(degToEnc(fixDeg(deg)));
    }

    public double degToEnc(double deg) {
        return (deg * ENCODER_UNITS_IN_ROTATION) / DEG_IN_TURRET_ROTATION;
    }

    public double encToDeg(double enc) {
        return (enc * DEG_IN_TURRET_ROTATION) / ENCODER_UNITS_IN_ROTATION;
    }

    public double fixDeg(double deg) {
        double fixed = deg % DEG_IN_CIRCLE;
        if (fixed > MAX_DEG){
            fixed -= DEG_IN_CIRCLE;
        } if (fixed < MIN_DEG){
            fixed += DEG_IN_CIRCLE;
        } return fixed;
    }

    public boolean isOnTarget() {
        return components.getController().isOnTarget(degToEnc(TOLERANCE_DEGREE));
    }
}
