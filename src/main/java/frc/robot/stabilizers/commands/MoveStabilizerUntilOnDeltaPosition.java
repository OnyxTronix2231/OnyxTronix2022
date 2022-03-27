package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnDeltaPosition extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnDeltaPosition(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier,
                                         IntSupplier positionSupplier) {
        super(new WaitUntilStabilizersOnDeltaPositionByEncoder(advancedClimber, positionSupplier),
                new MoveStabilizerBySpeed(advancedClimber, speedSupplier));
    }
}
