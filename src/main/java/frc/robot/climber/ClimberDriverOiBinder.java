package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbByPhase;
import frc.robot.climber.commands.ClimbLevel;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(final Climber climber, final Trigger climbLevel, final Trigger climbingSequence) {
        climbLevel.whenActive(new ClimbLevel(climber, () -> PERCENT_OUTPUT));
    }
}
