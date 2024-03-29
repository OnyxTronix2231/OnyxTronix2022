package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.advancedClimber.commands.AutoClimb;
import frc.robot.advancedClimber.commands.ReleaseArmsStageThree;
import frc.robot.arms.Arms;
import frc.robot.providers.ButtonProvider;
import frc.robot.providers.ReleaseArmsButtonClicked;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.ARMS_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.STABILIZERS_SPEED;

public class DeputyAutoClimbOiBinder {

    public DeputyAutoClimbOiBinder(AdvancedClimber advancedClimber, Arms arms, Trigger autoClimb,
                                   Trigger releaseArms, ButtonProvider buttonProvider) {
        autoClimb.whileActiveContinuous(new AutoClimb(advancedClimber, arms, buttonProvider));
        releaseArms.whenActive(new ReleaseArmsStageThree(advancedClimber, arms));
    }
}
