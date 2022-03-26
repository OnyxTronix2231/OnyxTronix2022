package frc.robot.arms;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arms extends SubsystemBase {

    protected final ArmsComponents components;
    //private final ArmsShuffleBoard climberShuffleBoard;

    public Arms(ArmsComponents components) {
        this.components = components;
        //climberShuffleBoard = new ArmsShuffleBoard(this);
    }

    public boolean isEncoderOnTarget(int desiredPosition) {
        return Math.abs(getEncoderUnits()) >= Math.abs(desiredPosition);
    }

    public double getEncoderUnits() {
        return components.getMasterMotorEncoder().getCount();
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
