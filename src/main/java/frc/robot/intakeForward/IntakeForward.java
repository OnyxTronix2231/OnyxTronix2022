package frc.robot.intakeForward;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_CLOSE;
import static frc.robot.intakeForward.IntakeForwardConstant.SOLENOID_OPEN;

public class IntakeForward extends SubsystemBase {

    private final IntakeForwardComponents forwardComponents;

    public IntakeForward(frc.robot.intakeForward.IntakeForwardComponents forwardComponents) {
        this.forwardComponents = forwardComponents;
    }

    public void moveBySpeed(double speed){
        forwardComponents.getMotor().set(speed);
    }

    public void stop(){
        moveBySpeed(0);
    }

    public void openSolenoid(){
        forwardComponents.getSolenoid().set(SOLENOID_OPEN);
    }

    public void closeSolenoid(){
        forwardComponents.getSolenoid().set(SOLENOID_CLOSE);
    }
}
