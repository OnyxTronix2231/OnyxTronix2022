package frc.robot.climber;
import static frc.robot.climber.ClimberConstants.*;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbByPhase;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(final Climber climber, final Trigger climbByPhase, final Trigger climbingSequence) {
        climbByPhase.whileActiveOnce(new ClimbByPhase(climber, () -> ARM_DISTANCE, () -> ARM_DISTANCE_2, () -> PERCENT_OUTPUT));
    }
}
