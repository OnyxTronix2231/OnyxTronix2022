package frc.robot.stabilizers;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Stabilizer extends SubsystemBase {

    private final StabilizerComponents components;

    public Stabilizer(StabilizerComponents components) {
        this.components = components;
        Shuffleboard.getTab("main").addNumber("pos" ,()-> components.getEncoder().getCount());
    }

    public void moveStabilizerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stopMotor() {
        moveStabilizerBySpeed(0);
    }

    public boolean isEncoderOnTarget(int desiredPosition) {
        return Math.abs(getEncoderUnits()) >= Math.abs(desiredPosition);
    }

    private double encoderUnits;

    public void initEncoderUnits() {
        encoderUnits = getEncoderUnits();
    }

    public boolean isEncoderOnTargetPositive(int desiredPosition) {
        return Math.abs(getEncoderUnits()) - Math.abs(encoderUnits) > desiredPosition;
    }

    public double getEncoderUnits() {
        return components.getEncoder().getCount();
    }
}
