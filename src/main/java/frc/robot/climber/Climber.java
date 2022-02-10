package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.*;
import static frc.robot.climber.ClimberConstants.Calculations.armMeterToEncoderUnits;
import static frc.robot.climber.ClimberConstants.Calculations.railMeterToEncoderUnits;

public class Climber extends SubsystemBase {

    private final ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;
    }

    public void initMoveLeftArmByDistance(double distance) {
        components.getArmLeftMotionMagicController().setSetpoint(armMeterToEncoderUnits(distance));
        components.getArmLeftMotionMagicController().enable();
    }

    public void initMoveRightArmByDistance(double distance) {
        components.getArmRightMotionMagicController().setSetpoint(armMeterToEncoderUnits(distance));
        components.getArmRightMotionMagicController().enable();
    }

    public void updateMoveLeftArmByDistance(double distance) {
        components.getArmLeftMotionMagicController().update(armMeterToEncoderUnits(distance));
    }

    public void updateMoveRightArmByDistance(double distance) {
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
        components.getRailMotionMagicController().disable();
    }

    public void moveRightArmBySpeed(double speed) {
        components.getArmMotorRight().set(speed);
    }

    public void moveLeftArmBySpeed(double speed){
        components.getArmMotorLeft().set(speed);
    }

    public void stopArmLeftMotor() {
        moveLeftArmBySpeed(0);
        components.getArmLeftMotionMagicController().disable();
    }
    public void stopArmRightMotor() {
        moveRightArmBySpeed(0);
        components.getArmRightMotionMagicController().disable();
    }

    public boolean isInnerHallEffectClosed() {
        return components.getInnerHallEffect().get();
    }

    public boolean isLeftArmOnTarget() {
        return components.getArmLeftMotionMagicController().isOnTarget(ARM_TOLERANCE);
    }

    public boolean isRightArmOnTarget() {
        return components.getArmRightMotionMagicController().isOnTarget(ARM_TOLERANCE);
    }

    public boolean isRailOnTarget() {
        return components.getRailMotionMagicController().isOnTarget(RAIL_TOLERANCE);
    }
//    public boolean isOuterHallEffectClosed() {
//        return components.getOuterHallEffect().get();
//    }
}
