package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveStabilizerUntilOnPosition extends ParallelDeadlineGroup {

    public MoveStabilizerUntilOnPosition(Climber climber, DoubleSupplier speedSupplier, IntSupplier positionSupplier) {
        super(new WaitUntilStabilizersOnPositionByEncoder(climber, positionSupplier), new MoveStabilizerBySpeed(climber, speedSupplier));
    }
}
