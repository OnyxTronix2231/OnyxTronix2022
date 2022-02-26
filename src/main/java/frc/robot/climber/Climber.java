package frc.robot.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.*;

public class Climber extends SubsystemBase {
    private final ClimberComponents components;

    public Climber(ClimberComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed) {
        components.getRightMotor().set(speed);
        components.getLeftMotor().set(speed);
    }

    public void stopMotors() {
        moveBySpeed(0);
    }

    public void openSolenoid() {
        components.getDoubleSolenoid().set(SOLENOID_OPEN_VALUE);
    }

    public void closeSolenoid() {
        components.getDoubleSolenoid().set(SOLENOID_CLOSE_VALUE);
    }
}
