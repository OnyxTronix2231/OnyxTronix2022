package frc.robot.climber;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.Calculations.*;

public class Climber extends SubsystemBase {

    private final ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;

    }

    public void initMoveByDistance(double distance) {
        components.getMotionMagicController().setSetpoint(meterToEncoderUnits(distance));
        components.getMotionMagicController().enable();
    }

    public void updateMoveByDistance(double distance) {
        components.getMotionMagicController().update(meterToEncoderUnits(distance));
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
