package frc.robot.intake;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.OpenPiston;

import static frc.robot.intake.IntakeConstant.JOYSTICK_VALUE;

public class IntakeShuffleboard {

    private final Intake intake;
    private NetworkTableEntry joyStick;

    public IntakeShuffleboard(Intake intake) {
        this.intake = intake;
    }

    public void init() {
        joyStick = Shuffleboard.getTab("Intake").add("JoystickValue" + intake.getName(), 0.0).getEntry();

        Shuffleboard.getTab("Intake").add("Open" + intake.getName(), new OpenPiston(intake));

        Shuffleboard.getTab("Intake").add("Close" + intake.getName(), new ClosePiston(intake));
    }

    public double getJoystickValue() {
        return joyStick != null ? joyStick.getDouble(JOYSTICK_VALUE) : JOYSTICK_VALUE;
    }
}
