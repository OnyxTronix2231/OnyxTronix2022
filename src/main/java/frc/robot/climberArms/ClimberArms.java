package frc.robot.climberArms;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberArms extends SubsystemBase {

    protected final ClimberArmsComponents components;
    private final ClimberShuffleBoard climberShuffleBoard;

    public ClimberArms(ClimberArmsComponents components) {
        this.components = components;
        climberShuffleBoard = new ClimberShuffleBoard(this);
    }

    public void moveArmsBySpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void stopArms() {
        moveArmsBySpeed(0);
    }

    public double getArmsEncoderUnits() {
        return components.getMasterMotorEncoder().getCount();
    }
}
