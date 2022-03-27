package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.stabilizers.commands.WaitUntilStabilizersOnPositionByEncoder;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class MoveArmsUntilOnPitch extends ParallelDeadlineGroup {

    public MoveArmsUntilOnPitch(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier speedSupplier,
                                DoubleSupplier pitchSupplier) {
        super(new WaitUntilClimbedByPitch(advancedClimber, pitchSupplier),
                new MoveArmsBySpeed(arms, speedSupplier));
    }
}
