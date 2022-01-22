package frc.robot.intakeForward.commands;

import frc.robot.intakeForward.IntakeForward;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

public class IntakeBySpeed extends CommandBase {

    private final IntakeForward intake;
    private final DoubleSupplier speedSupplier;

    public IntakeBySpeed(IntakeForward intake, DoubleSupplier speedSupplier) {
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
