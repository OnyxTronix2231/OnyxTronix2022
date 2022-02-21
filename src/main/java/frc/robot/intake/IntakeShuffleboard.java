package frc.robot.intake;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

import static frc.robot.intake.IntakeConstant.JOYSTICK_VALUE;

public class IntakeShuffleboard {

    NetworkTableEntry joyStick;

    public IntakeShuffleboard(Intake intake) {
        joyStick = Shuffleboard.getTab("Intake").add("JoystickValue" + intake.getName(), 0.0).getEntry();

        Shuffleboard.getTab("Intake").add("Open"+intake.getName(), new OpenPiston(intake));

        Shuffleboard.getTab("Intake").add("Close"+intake.getName(), new ClosePiston(intake));


        var Intake = Shuffleboard.getTab("Intake").add("Intake"+intake.getName()+"Speed",
                0.0).getEntry();
    }

    public double getJoystickValue() {
        return joyStick.getDouble(JOYSTICK_VALUE);
    }
}
