package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.advancedClimber.commands.AutoClimb;
import frc.robot.arms.Arms;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.ARMS_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.STABILIZERS_SPEED;

public class DeputyAutoClimbOiBinder {

    public DeputyAutoClimbOiBinder(AdvancedClimber advancedClimber, Arms arms, Trigger autoClimb) {
        autoClimb.whenActive(new AutoClimb(advancedClimber, arms, () -> STABILIZERS_SPEED, () -> ARMS_SPEED));
    }
}
