package frc.robot.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.intake.commands.OpenAndCloseAsNeeded;

import static frc.robot.intake.IntakeConstant.SOLENOID_CLOSE;
import static frc.robot.intake.IntakeConstant.SOLENOID_OPEN;

public class Intake extends SubsystemBase {

    private final IntakeComponents components;
    private final IntakeShuffleboard intakeShuffleboard;
    public Intake(IntakeComponents components, String name) {
        this.components = components;
        this.setName(name);
        this.intakeShuffleboard = new IntakeShuffleboard(this);
    }

    public void moveBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public void openSolenoid() {
        components.getSolenoid().set(SOLENOID_OPEN);
    }

    public void closeSolenoid() {
        components.getSolenoid().set(SOLENOID_CLOSE);
    }

    public boolean isFrontOpen() {
        return components.getSolenoid().get() == DoubleSolenoid.Value.kForward;
    }

    public double getJoyStickValue(){
        return intakeShuffleboard.getJoystickValue();
    }
}
