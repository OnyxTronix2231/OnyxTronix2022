package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.turret.TurretConstants.*;

public class Turret extends SubsystemBase {
    private TurretComponents components;

    public Turret(TurretComponents turretComponents) {
        this.components = turretComponents;

        this.components.getMotor().configForwardSoftLimitThreshold(degToEnc(MAX_DEG));
        this.components.getMotor().configForwardSoftLimitEnable(true);
        this.components.getMotor().configReverseSoftLimitThreshold(degToEnc(MIN_DEG));
        this.components.getMotor().configReverseSoftLimitEnable(true);
    }

    public void setspeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop(){
        setspeed(0);
        components.getController().disable();
    }

    public double degToEnc(double deg){
        return (deg * ENCODER_UNITS_IN_ROTATION) / (CONVERSION_RATE * DEG_IN_ROTATION);
    }

    public double fixDeg(double deg){
        double fixed = deg % DEG_IN_ROTATION;
        if (fixed > MAX_DEG){
            fixed -= DEG_IN_ROTATION;
        } else if (fixed < MIN_DEG){
            fixed += DEG_IN_ROTATION;
        } return fixed;
    }

    public void initMoveByDegree(double deg){
        components.getController().setSetpoint(degToEnc(deg));
        components.getController().enable();
    }

    public void updateMoveByDegree(double deg){
        components.getController().update(degToEnc(deg));
    }
}
