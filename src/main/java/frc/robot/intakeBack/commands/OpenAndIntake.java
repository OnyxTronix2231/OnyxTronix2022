package frc.robot.intakeBack.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.intakeBack.IntakeBack;

import java.util.function.DoubleSupplier;

public class OpenAndIntake extends SequentialCommandGroup {


    public OpenAndIntake(IntakeBack intakeBack, DoubleSupplier speedSupplier) {
        super(
                new OpenSolenoid(intakeBack),
                new IntakeBySpeed(intakeBack, speedSupplier)
                //new CloseSolenoid(intake)   //this should be removed when i do oidriver
        );
    }


}
