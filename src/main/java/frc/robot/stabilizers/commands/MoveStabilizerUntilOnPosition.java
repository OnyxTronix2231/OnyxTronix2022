package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnPosition extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnPosition(Stabilizer climberStabilizer, DoubleSupplier speedSupplier,
                                         IntSupplier positionSupplier) {
        super(new WaitUntilStabilizersOnPositionByEncoder(climberStabilizer, positionSupplier),
                new MoveStabilizerBySpeed(climberStabilizer, speedSupplier));
    }
}
