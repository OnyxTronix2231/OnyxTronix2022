package frc.robot.climber;
import static frc.robot.climber.ClimberConstants.*;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbByPhase;
import frc.robot.climber.commands.MicroSwitchTest;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(final Climber climber, final Trigger climbByPhase, final Trigger climbingSequence, final Trigger microSwitchTest) {
        climbByPhase.whileActiveOnce(new ClimbByPhase(climber, () -> ARM_DISTANCE, () -> ARM_DISTANCE_2, () -> PERCENT_OUTPUT));
        microSwitchTest.whileActiveContinuous(new MicroSwitchTest(climber));
    }
    public ClimberDriverOiBinder(final Climber climber, final Trigger microSwitchTest) {
        microSwitchTest.whileActiveContinuous(new MicroSwitchTest(climber));
    }
}
