package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.advancedClimber.commands.AutoClimb;
import frc.robot.arms.Arms;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.ARMS_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.STABILIZERS_SPEED;

public class DeputyAutoClimbOiBinder {

    public DeputyAutoClimbOiBinder(AdvancedClimber advancedClimber, Arms arms, Vision vision, Trigger autoClimb,
                                   DoubleSupplier desiredPitchAngleStageOne, DoubleSupplier desiredPitchAngleStageTwo) {
        autoClimb.whileActiveContinuous(new AutoClimb(advancedClimber, arms, vision, desiredPitchAngleStageOne, desiredPitchAngleStageTwo));
    }
}
