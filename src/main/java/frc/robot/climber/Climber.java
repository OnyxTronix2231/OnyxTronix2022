package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.DESIRED_STABILIZER_MOTOR_ENCODER_UNITS;

public class Climber extends SubsystemBase {

    protected final ClimberComponents components;
    private final ClimberShuffleBoard climberShuffleBoard;

    public Climber(ClimberComponents components) {
        this.components = components;
        climberShuffleBoard = new ClimberShuffleBoard(this);
    }

    public void moveArmsBySpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void stopArms() {
        moveArmsBySpeed(0);
    }

    public void moveStabilizerMotorBySpeed(double speed) {
        components.getStabilizerMotor().set(speed);
    }

    public void stopStabilizer() {
        moveStabilizerMotorBySpeed(0);
    }

    public double getArmsEncoderUnits() {
        return components.getMasterMotorEncoder().getCount();
    }

    public boolean isStabilizerMotorEncoderOnTarget(int desiredPosition) {
        return getStabilizerMotorEncoderUnits() >= desiredPosition;
    }

    public double getStabilizerMotorEncoderUnits() {
        return components.getStabilizerMotorEncoder().getCount();
    }
}
