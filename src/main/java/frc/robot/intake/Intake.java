package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.intake.IntakeConstant.PISTON_CLOSE;
import static frc.robot.intake.IntakeConstant.PISTON_OPEN;

public class Intake extends SubsystemBase {

    private final IntakeComponents components;
    private final IntakeShuffleboard intakeShuffleboard;

    public Intake(IntakeComponents components, String name) {
        this.components = components;
        this.setName(name);
        this.intakeShuffleboard = new IntakeShuffleboard(this);
        //intakeShuffleboard.init();
    }

    public void moveBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public void openPiston() {
        components.getSolenoid().set(PISTON_OPEN);
    }

    public void closePiston() {
        components.getSolenoid().set(PISTON_CLOSE);
    }
}
