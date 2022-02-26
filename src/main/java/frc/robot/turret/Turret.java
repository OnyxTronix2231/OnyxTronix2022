package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.ComponentsConstants.*;
import static frc.robot.turret.TurretConstants.Calculation.*;

public class Turret extends SubsystemBase {

    private final TurretComponents components;
    private final TurretShuffleBoard turretShuffleBoard;

    public Turret(TurretComponents turretComponents) {
        components = turretComponents;
        turretShuffleBoard = new TurretShuffleBoard(this, components);
    }

    @Override
    public void periodic() {
        turretShuffleBoard.update();
    }

    public double getCurrentAngleRTR() {
        return absoluteEncoderUnitsToDegrees(components.getEncoder().getCount());
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void initMoveToDegreeRTR(double deg) {
        components.getController().setSetpoint(degreesToEncoderUnits(fixAngleAccordingToLimits(deg)));
        components.getController().enable();
    }

    public void updateMoveToDegreeRTR(double deg) {
        components.getController().update(degreesToEncoderUnits(fixAngleAccordingToLimits(deg)));
    }

    public double fixAngleAccordingToLimits(double deg) {
        double fixedAngle = deg % DEG_IN_CIRCLE;
        if (fixedAngle > MAX_DEG) {
            fixedAngle -= DEG_IN_CIRCLE;
        }
        if (fixedAngle < MIN_DEG) {
            fixedAngle += DEG_IN_CIRCLE;
        }
        return fixedAngle;
    }

    public boolean isOnTarget() {
        System.out.println(degreesToEncoderUnits(TOLERANCE_DEGREES));
        return components.getController().isOnTarget(degreesToEncoderUnits(TOLERANCE_DEGREES));
    }

    public boolean isCalibrated() {
       //boolean fwdClosed = components.getMotor().getSensorCollection().isFwdLimitSwitchClosed() == 1;
       //boolean revClosed = components.getMotor().getSensorCollection().isRevLimitSwitchClosed() == 1;
       //return fwdClosed && revClosed;
        return true;
    }

    public void activateSoftLimits() {
        //components.getEncoder().reset();
        components.getMotor().configForwardSoftLimitEnable(true);
        components.getMotor().configReverseSoftLimitEnable(true);
    }
}
