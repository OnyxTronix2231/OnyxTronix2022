package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnPositionStages extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnPositionStages(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier,
                                         IntSupplier positionSupplier, int stage) {
        super(new WaitUntilStabilizersOnPositionByEncoderStages(advancedClimber, positionSupplier, stage),
                new MoveStabilizerBySpeed(advancedClimber, speedSupplier));
    }
}
