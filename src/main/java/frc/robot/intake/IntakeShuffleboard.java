package frc.robot.intake;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

public class IntakeShuffleboard {

    public IntakeShuffleboard(Intake intakeFront, Intake intakeBack) {
        Shuffleboard.getTab("Intake").add("OpenFront", new OpenPiston(intakeFront));
        Shuffleboard.getTab("Intake").add("OpenBack", new OpenPiston(intakeBack));

        Shuffleboard.getTab("Intake").add("CloseFront", new ClosePiston(intakeFront));
        Shuffleboard.getTab("Intake").add("CloseBack", new ClosePiston(intakeBack));

        var IntakeFront  = Shuffleboard.getTab("Intake").add("IntakeFrontSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("Intake").add("IntakeFrontSpeed", new IntakeBySpeed( intakeFront,()->IntakeFront.getDouble(0)));

        var IntakeBack  = Shuffleboard.getTab("Intake").add("IntakeBackSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("Intake").add("IntakeBackSpeed", new IntakeBySpeed(intakeBack,()->IntakeBack.getDouble(0)));
    }
}
