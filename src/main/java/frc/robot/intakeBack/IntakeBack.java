package frc.robot.intakeBack;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.intakeForward.IntakeComponents;

import static frc.robot.Constants.REGULAR_AMP;
import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_CLOSE;
import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_OPEN;


public class IntakeBack extends SubsystemBase {

    private final IntakeComponents components;

    public IntakeBack(IntakeComponents components) {
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

    public boolean isAdded(){
        return components.getMotor().getSupplyCurrent() >  REGULAR_AMP;
    }
}
