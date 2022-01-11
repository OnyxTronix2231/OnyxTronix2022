package frc.robot.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Intake.IntakeConstant.SOLENOID_CLOSE;
import static frc.robot.Intake.IntakeConstant.SOLENOID_OPEN;


public class Intake extends SubsystemBase {

    private final IntakeComponents components;

    public Intake(IntakeComponents components) {
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
