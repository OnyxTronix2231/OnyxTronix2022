package frc.robot.arms.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.stabilizers.commands.WaitUntilStabilizersOnPositionByEncoder;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveArmsUntilOnPosition extends ParallelDeadlineGroup {

    private final AdvancedClimber advancedClimber;

    public MoveArmsUntilOnPosition(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier speedSupplier,
                                   IntSupplier positionSupplier) {
        super(new WaitUntilArmsOnPositionByEncoder(advancedClimber, arms, positionSupplier,3),
                new MoveArmsBySpeed(arms, speedSupplier));
        this.advancedClimber = advancedClimber;
    }
}
