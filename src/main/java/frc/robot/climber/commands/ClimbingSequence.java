package frc.robot.climber.commands;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_SPEED;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;

public class ClimbingSequence extends SequentialCommandGroup {

    public ClimbingSequence(Climber climber) {
        super(new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen),
            new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerMicroSwitchOpen),
            new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen),
            new MoveRailUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerMicroSwitchOpen),
            new MoveRailUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen));
    }
}
