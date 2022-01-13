package frc.robot.Intake.commands;

import frc.robot.Intake.Intake;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.DoubleSupplier;

public class OpenAndIntake extends SequentialCommandGroup {


    public OpenAndIntake(Intake intake, DoubleSupplier speedSupplier) {
        super(
                new OpenSolenoid(intake),
                new IntakeBySpeed(intake, speedSupplier),
                new CloseSolenoid(intake)   //this should be removed when i do oidriver
        );
    }


}
