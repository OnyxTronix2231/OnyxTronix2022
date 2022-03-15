package frc.robot.ClimberStabilizers.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.ClimberStabilizers.ClimberStabilizers;
import frc.robot.climberArms.ClimberArms;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnPosition extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnPosition(ClimberStabilizers climberStabilizers, DoubleSupplier speedSupplier,
                                         IntSupplier positionSupplier) {
        super(new WaitUntilStabilizersOnPositionByEncoder(climberStabilizers, positionSupplier),
                new MoveStabilizerBySpeed(climberStabilizers, speedSupplier));
    }
}
