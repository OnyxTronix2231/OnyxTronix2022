package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.Calculations.*;

public class Climber extends SubsystemBase {

    private final ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;

    }

    public void initMoveArmByDistance(double distance) {
        components.getArmMotionMagicController().setSetpoint(armMeterToEncoderUnits(distance));
        components.getArmMotionMagicController().enable();
    }

    public void updateMoveArmByDistance(double distance) {
        components.getArmMotionMagicController().update(armMeterToEncoderUnits(distance));
    }
    public void initMoveRailByDistance(double distance) {
        components.getRailMotionMagicController().setSetpoint(railMeterToEncoderUnits(distance));
        components.getRailMotionMagicController().enable();
    }

    public void updateMoveRailByDistance(double distance) {
        components.getRailMotionMagicController().update(railMeterToEncoderUnits(distance));
    }

    public void moveRailBySpeed(double speed) {
        components.getRailMotor().set(speed);
    }

    public void stopRailMotor() {
        moveRailBySpeed(0);
    }

    public void moveArmBySpeed(double speed) {
        components.getArmMotor().set(speed);
    }

    public void stopArmMotor() {
        moveArmBySpeed(0);
    }

    public boolean isInnerMicroSwitchOpen() {
        return components.getInnerMicroSwitch().isOpen();
    }

    public boolean isOuterMicroSwitchOpen() {
        return components.getOuterMicroSwitch().isOpen();
    }
}
