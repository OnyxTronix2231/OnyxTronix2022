package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.stabilizers.Stabilizers;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerBackAndForth extends SequentialCommandGroup {

    public MoveStabilizerBackAndForth(Stabilizers climberStabilizers, DoubleSupplier forwardSpeedSupplier,
                                      DoubleSupplier backwardSpeedSupplier, IntSupplier forwardDesiredPosition,
                                      IntSupplier backwardDesiredPosition) {
        super(new MoveStabilizerUntilOnPosition(climberStabilizers, forwardSpeedSupplier, backwardDesiredPosition),
                new MoveStabilizerUntilOnPosition(climberStabilizers,backwardSpeedSupplier,backwardDesiredPosition));

    }
}
