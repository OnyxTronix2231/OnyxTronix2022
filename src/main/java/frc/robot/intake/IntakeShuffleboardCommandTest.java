package frc.robot.intake;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

public class IntakeShuffleboardCommandTest {

    public IntakeShuffleboardCommandTest(Intake intakeFront, Intake intakeBack) {
        Shuffleboard.getTab("intake").add("open front", new OpenPiston(intakeFront));
        Shuffleboard.getTab("intake").add("open back", new OpenPiston(intakeBack));

        Shuffleboard.getTab("intake").add("close front", new ClosePiston(intakeFront));
        Shuffleboard.getTab("intake").add("close back", new ClosePiston(intakeBack));

        var nimiFront  = Shuffleboard.getTab("intake").add("front-intake-speed",
                0.0).getEntry();
        Shuffleboard.getTab("intake").add("intake front speed", new IntakeBySpeed( intakeFront,()->nimiFront.getDouble(0)));

        var nimiBack  = Shuffleboard.getTab("intake").add("back-intake-speed",
                0.0).getEntry();
        Shuffleboard.getTab("intake").add("intake back speed", new IntakeBySpeed(intakeBack,()->nimiBack.getDouble(0)));
    }
}
