package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbByPhase;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(final Climber climber, final Trigger climbByPhase, final Trigger climbingSequence) {
        climbByPhase.whileActiveOnce(new ClimbByPhase(climber, () -> PERCENT_OUTPUT));
    }
}
