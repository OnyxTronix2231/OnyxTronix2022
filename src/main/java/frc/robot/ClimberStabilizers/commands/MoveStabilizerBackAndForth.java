package frc.robot.ClimberStabilizers.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.ClimberStabilizers.ClimberStabilizers;
import frc.robot.climberArms.ClimberArms;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerBackAndForth extends SequentialCommandGroup {

    public MoveStabilizerBackAndForth(ClimberStabilizers climberStabilizers, DoubleSupplier forwardSpeedSupplier,
                                      DoubleSupplier backwardSpeedSupplier, IntSupplier forwardDesiredPosition,
                                      IntSupplier backwardDesiredPosition) {
        super(new MoveStabilizerUntilOnPosition(climberStabilizers, forwardSpeedSupplier, backwardDesiredPosition),
                new MoveStabilizerUntilOnPosition(climberStabilizers,backwardSpeedSupplier,backwardDesiredPosition));

    }
}
