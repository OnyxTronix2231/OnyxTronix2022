package frc.robot.intake.commands;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

public class IntakeShuffleboardCommandTest {

    public IntakeShuffleboardCommandTest(Intake intakeFront, Intake intakeBack) {
        Shuffleboard.getTab("intake").add(new OpenPiston(intakeFront));
        Shuffleboard.getTab("intake").add(new OpenPiston(intakeBack));

        Shuffleboard.getTab("intake").add(new ClosePiston(intakeFront));
        Shuffleboard.getTab("intake").add(new ClosePiston(intakeBack));

        var nimiFront  = Shuffleboard.getTab("intake").add("front-intake-speed",
                0.0).getEntry();
        Shuffleboard.getTab("intake").add(new IntakeBySpeed(intakeFront,()->nimiFront.getDouble(0)));

        var nimiBack  = Shuffleboard.getTab("intake").add("back-intake-speed",
                0.0).getEntry();
        Shuffleboard.getTab("intake").add(new IntakeBySpeed(intakeBack,()->nimiBack.getDouble(0)));
    }
}
