package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.stabilizers.Stabilizers;

import java.util.function.DoubleSupplier;

public class MoveStabilizerBySpeed extends CommandBase {

    private final Stabilizers climberStabilizers;
    private final DoubleSupplier speedSupplier;

    public MoveStabilizerBySpeed(Stabilizers climberStabilizers, DoubleSupplier speedSupplier) {
        this.climberStabilizers = climberStabilizers;
        this.speedSupplier = speedSupplier;
    }

    @Override
    public void execute() {
        climberStabilizers.moveMotorBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climberStabilizers.stopMotor();
    }
}
