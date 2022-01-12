package frc.robot.climber.commands;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_SPEED;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;
import frc.robot.climber.ClimberComponents;
import frc.robot.climber.ClimberComponentsBase;

import java.util.function.DoubleSupplier;

public class ClimbingSequence extends SequentialCommandGroup {

    public ClimbingSequence(Climber climber) {
        super(new MoveClimberUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen),
            new MoveClimberUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerMicroSwitchOpen),
            new MoveClimberUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen),
            new MoveClimberUntilConditions(climber, () -> -CLIMBER_SPEED, climber::isInnerMicroSwitchOpen),
            new MoveClimberUntilConditions(climber, () -> CLIMBER_SPEED, climber::isOuterMicroSwitchOpen));
    }
}
