package frc.robot.stabilizers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Stabilizer extends SubsystemBase {

    private final StabilizerComponents components;

    public Stabilizer(StabilizerComponents components) {
        this.components = components;
    }

    public void moveStabilizerBySpeed(double speed) {
        components.getMotor().set(0);
    }

    public void stopMotor() {
        moveStabilizerBySpeed(0);
    }

    public boolean isEncoderOnTarget(int desiredPosition) {
        return getEncoderUnits() >= desiredPosition;
    }

    public double getEncoderUnits() {
        return components.getEncoder().getCount();
    }
}