package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.arms.commands.MoveArmsUntilOnPosition;
import frc.robot.providers.ButtonProvider;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class AutoClimb extends SequentialCommandGroup {

    public AutoClimb(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier desiredArmsSpeed,
                     IntSupplier desiredArmsDelta, DoubleSupplier keepStabilizerSpeed,
                     ButtonProvider buttonProvider) {
        super(
                new ClimbWithArmsStageOneUntilPitch(advancedClimber, arms, () -> DESIRED_PITCH_ANGLE_STAGE_ONE),
                new ClimbWithStabilizersAndArmsStageZeroUntilPitch(advancedClimber, arms, () -> DESIRED_ARMS_SPEED_STAGE_ZERO, stabilizerPosition),
                new MoveNow(advancedClimber, arms, () -> DESIRED_ARMS_SPEED_STAGE_ZERO),
//                new MoveArmsUntilOnPosition(advancedClimber, arms, desiredArmsSpeed, desiredArmsDelta),
                new ClimbWithStabilizersAndArmsStageTwoUntilPitch(advancedClimber, () -> DESIRED_PITCH_ANGLE_STAGE_TWO),
                new KeepPowerStabilizer(advancedClimber,keepStabilizerSpeed, buttonProvider),
                new EveryoneClaps());
    }
}
