package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class OpenAndIntake extends SequentialCommandGroup {

    private final Intake intake;

    public OpenAndIntake(Intake intake, DoubleSupplier speedSupplier) {
        super(new OpenPiston(intake), new MoveIntakeBySpeed(intake, speedSupplier));
        this.intake = intake;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        intake.closePiston();
    }
}
