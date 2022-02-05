package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeBySpeed extends CommandBase {

    private final Intake intake;
    private final DoubleSupplier speedSupplier;

    public IntakeBySpeed(Intake intake, DoubleSupplier speedSupplier) {
        this.intake = intake;

        this.speedSupplier = speedSupplier;

        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.moveBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}
