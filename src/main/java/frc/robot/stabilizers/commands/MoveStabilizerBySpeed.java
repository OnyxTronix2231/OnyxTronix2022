package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.DoubleSupplier;

public class MoveStabilizerBySpeed extends CommandBase {

    private final Stabilizer stabilizer;
    private final DoubleSupplier speedSupplier;

    public MoveStabilizerBySpeed(Stabilizer stabilizer, DoubleSupplier speedSupplier) {
        this.stabilizer = stabilizer;
        this.speedSupplier = speedSupplier;
    }

    @Override
    public void execute() {
        stabilizer.moveStabilizerBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        stabilizer.stopMotor();
    }
}
