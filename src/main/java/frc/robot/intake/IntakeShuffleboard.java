package frc.robot.intake;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

import static frc.robot.intake.IntakeConstant.JOYSTICK_VALUE;

public class IntakeShuffleboard {

    NetworkTableEntry joyStick;

    public IntakeShuffleboard(Intake intake) {
        Shuffleboard.getTab("Intake").add("OpenFront", new OpenPiston(intake));

        Shuffleboard.getTab("Intake").add("Close"+intake.getName(), new ClosePiston(intake));

        var Intake = Shuffleboard.getTab("Intake").add("IntakeFrontSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("Intake").add("IntakeFrontSpeed", new IntakeBySpeed(intake, () -> Intake.getDouble(0)));

        joyStick = Shuffleboard.getTab("Intake").add("JoystickValue", 0.0).getEntry();
        Shuffleboard.getTab("Intake").addNumber("JoystickValue", this::getJoystickValue);
    }

    public double getJoystickValue() {
        return joyStick.getDouble(JOYSTICK_VALUE);
    }
}
