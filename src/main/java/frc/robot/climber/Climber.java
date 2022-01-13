package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    private ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;
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
