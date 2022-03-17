package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.stabilizers.Stabilizers;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnPosition extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnPosition(Stabilizers climberStabilizers, DoubleSupplier speedSupplier,
                                         IntSupplier positionSupplier) {
        super(new WaitUntilStabilizersOnPositionByEncoder(climberStabilizers, positionSupplier),
                new MoveStabilizerBySpeed(climberStabilizers, speedSupplier));
    }
}
