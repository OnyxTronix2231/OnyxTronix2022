package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;

import static frc.robot.climber.commands.ClimberCommandConstants.*;

public class ClimbingSequence extends SequentialCommandGroup {

    public ClimbingSequence(Climber climber) {
        super(new MoveRailByDistance(climber, () -> DISTANCE_BETWEEN_BEAMS),
                new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerHallEffectClosed),
                new MoveRailByDistance(climber, () -> DISTANCE_BETWEEN_BEAMS),
                new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerHallEffectClosed),
                new MoveRailByDistance(climber, () -> DISTANCE_BETWEEN_BEAMS));
    }
}
