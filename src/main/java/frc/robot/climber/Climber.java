package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    private ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void stopMotors() {
        moveBySpeed(0);
    }

    public boolean isInnerMicroSwitchOpen() {
        return components.getInnerMicroSwitch().isOpen();
    }

    public boolean isOuterMicroSwitchOpen() {
        return components.getOuterMicroSwitch().isOpen();
    }
}
