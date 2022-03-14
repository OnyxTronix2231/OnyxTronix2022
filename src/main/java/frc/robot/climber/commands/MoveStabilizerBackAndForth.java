package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerBackAndForth extends SequentialCommandGroup {

    public MoveStabilizerBackAndForth(Climber climber, DoubleSupplier forwardSpeedSupplier,
                                      DoubleSupplier backwardSpeedSupplier, IntSupplier forwardDesiredPosition,
                                      IntSupplier backwardDesiredPosition) {

        super(new MoveStabilizerUntilOnPosition(climber, forwardSpeedSupplier, backwardDesiredPosition),
                new MoveStabilizerUntilOnPosition(climber,backwardSpeedSupplier,backwardDesiredPosition));

    }
}
