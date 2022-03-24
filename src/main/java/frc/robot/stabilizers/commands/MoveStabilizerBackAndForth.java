package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerBackAndForth extends SequentialCommandGroup {

    public MoveStabilizerBackAndForth(Stabilizer climberStabilizer, DoubleSupplier forwardSpeedSupplier,
                                      DoubleSupplier backwardSpeedSupplier, IntSupplier forwardDesiredPosition,
                                      IntSupplier backwardDesiredPosition) {
        super(new MoveStabilizerUntilOnPosition(climberStabilizer, forwardSpeedSupplier, backwardDesiredPosition),
                new MoveStabilizerUntilOnPosition(climberStabilizer, backwardSpeedSupplier, backwardDesiredPosition));

    }
}
