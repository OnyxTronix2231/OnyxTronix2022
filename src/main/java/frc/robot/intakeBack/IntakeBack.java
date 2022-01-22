package frc.robot.intakeBack;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_CLOSE;
import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_OPEN;


public class IntakeBack extends SubsystemBase {

    private final IntakeBackComponents components;

    public IntakeBack(IntakeBackComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed){
        components.getMotor().set(speed);
    }

    public void stop(){
        moveBySpeed(0);
    }

    public void openSolenoid(){
        components.getSolenoid().set(SOLENOID_OPEN);
    }

    public void closeSolenoid(){
        components.getSolenoid().set(SOLENOID_CLOSE);
    }
}
