package frc.robot.arms.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.arms.Arms;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.stabilizers.commands.WaitUntilStabilizersOnPositionByEncoder;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveArmsUntilOnPosition extends ParallelDeadlineGroup {

    public MoveArmsUntilOnPosition(Arms arms, DoubleSupplier speedSupplier,
                                   IntSupplier positionSupplier) {
        super(new WaitUntilArmsOnPositionByEncoder(arms, positionSupplier),
                new MoveArmsBySpeed(arms, speedSupplier));
    }
}
