package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

import static frc.robot.intake.IntakeConstant.OPEN_INTAKE_WITH_DELAY_SECONDS;

public class OpenAndIntakeWithDelay extends SequentialCommandGroup {

    private final Intake intake;

    public OpenAndIntakeWithDelay(Intake intake, DoubleSupplier speedSupplier) {
        super(new OpenPiston(intake), new WaitCommand(OPEN_INTAKE_WITH_DELAY_SECONDS), new MoveIntakeBySpeed(intake, speedSupplier));
        this.intake = intake;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        intake.closePiston();
    }

}
