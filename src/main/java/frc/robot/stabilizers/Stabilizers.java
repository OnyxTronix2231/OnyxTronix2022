package frc.robot.stabilizers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Stabilizers extends SubsystemBase {

    private final StabilizersComponents components;

    public Stabilizers(StabilizersComponents components) {
        this.components = components;
    }

    public void moveMotorBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stopMotor() {
        moveMotorBySpeed(0);
    }

    public boolean isEncoderOnTarget(int desiredPosition) {
        return getEncoderUnits() >= desiredPosition;
    }

    public double getEncoderUnits() {
        return components.getEncoder().getCount();
    }
}
