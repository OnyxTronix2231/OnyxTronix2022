package frc.robot.intakeBack.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.intakeBack.IntakeBack;

import java.util.function.DoubleSupplier;

public class IntakeBySpeed extends CommandBase {

    private final IntakeBack intakeBack;
    private final DoubleSupplier speedSupplier;

    public IntakeBySpeed(IntakeBack intakeBack, DoubleSupplier speedSupplier) {
        this.intakeBack = intakeBack;

        this.speedSupplier = speedSupplier;

        addRequirements(intakeBack);
    }

    @Override
    public void execute() {
        intakeBack.moveBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        intakeBack.stop();
    }
}
