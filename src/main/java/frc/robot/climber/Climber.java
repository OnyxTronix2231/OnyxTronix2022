package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.climber.ClimberConstants.Calculations.armMeterToEncoderUnits;
import static frc.robot.climber.ClimberConstants.Calculations.railMeterToEncoderUnits;

public class Climber extends SubsystemBase {

    private final ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;

    }


    public void initMoveArmByDistance(double distance) {
        components.getArmLeftMotionMagicController().setSetpoint(armMeterToEncoderUnits(distance));
        components.getArmLeftMotionMagicController().enable();
        components.getArmRightMotionMagicController().setSetpoint(armMeterToEncoderUnits(distance));
        components.getArmRightMotionMagicController().enable();
    }

    public void updateMoveArmByDistance(double distance) {
        components.getArmLeftMotionMagicController().update(armMeterToEncoderUnits(distance));
        components.getArmRightMotionMagicController().update(armMeterToEncoderUnits(distance));

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
        components.getArmMotorRight().set(speed);
        components.getArmMotorLeft().set(speed);
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
