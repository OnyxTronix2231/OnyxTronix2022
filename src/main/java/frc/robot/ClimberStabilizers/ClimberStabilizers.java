package frc.robot.ClimberStabilizers;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberStabilizers extends SubsystemBase {

    private final ClimberStabilizersComponents components;

    public ClimberStabilizers(ClimberStabilizersComponents components) {
        this.components = components;
    }

    public void moveStabilizerMotorBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stopStabilizer() {
        moveStabilizerMotorBySpeed(0);
    }

    public boolean isStabilizerMotorEncoderOnTarget(int desiredPosition) {
        return getStabilizerMotorEncoderUnits() >= desiredPosition;
    }

    public double getStabilizerMotorEncoderUnits() {
        return components.getEncoder().getCount();
    }
}
