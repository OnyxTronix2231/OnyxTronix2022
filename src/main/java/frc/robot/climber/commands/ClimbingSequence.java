package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_SPEED;

public class ClimbingSequence extends SequentialCommandGroup {

    public ClimbingSequence(Climber climber) {
        super(new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterHallEffectClosed),
                new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerHallEffectClosed),
                new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterHallEffectClosed),
                new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerHallEffectClosed),
                new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterHallEffectClosed));
    }
}
