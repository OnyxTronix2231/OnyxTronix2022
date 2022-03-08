package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.climber.ClimberConstants.*;

public class Climber extends SubsystemBase {

    protected final ClimberComponents components;
    private final ClimberShuffleBoard climberShuffleBoard;

    public Climber(ClimberComponents components) {
        this.components = components;
        climberShuffleBoard = new ClimberShuffleBoard(this);
        climberShuffleBoard.init();
    }

    public void moveBySpeed(double speed) {
        components.getRightMotor().set(-speed);
        components.getLeftMotor().set(speed);
    }

    public void moveLeftArmBySpeed(double speed) {
        components.getLeftMotor().set(speed);
    }

    public void moveRightArmBySpeed(double speed) {
        components.getRightMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public void stopLeftArm() {
        moveLeftArmBySpeed(0);
    }

    public void stopRightArm() {
        moveRightArmBySpeed(0);
    }

    public double getLeftEncoderUnits() {
        return components.getLeftEncoder().getCount();
    }

    public double getRightEncoderUnits() {
        return components.getRightEncoder().getCount();
    }

    public void openPistons() {
        components.getDoubleSolenoid().set(SOLENOID_OPEN_VALUE);
    }

    public void closePistons() {
        components.getDoubleSolenoid().set(SOLENOID_CLOSE_VALUE);
    }

    public boolean isRightEncoderOnTarget() {
        return getRightEncoderUnits() >= DESIRED_ENCODER_UNITS;
    }

    public boolean isLeftEncoderOnTarget() {
        return getLeftEncoderUnits() >= DESIRED_ENCODER_UNITS;
    }
}
