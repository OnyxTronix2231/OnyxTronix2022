package frc.robot.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.BooleanSupplier;

import static frc.robot.intake.IntakeConstant.*;

public class Intake extends SubsystemBase {

    private final IntakeComponents components;

    public Intake(IntakeComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public void openSolenoid() {
        components.getSolenoid().set(SOLENOID_OPEN);
    }

    public void closeSolenoid() {
        components.getSolenoid().set(SOLENOID_CLOSE);
    }
    public boolean isFrontOpen(){
       return components.getSolenoid().get() == DoubleSolenoid.Value.kForward;
    }

    public boolean isMotorSpin(){
        return components.getMotor().getSupplyCurrent()<WHEN_MOTOR_SPINNING_CURRENT_SUPPLY;
    }
}
