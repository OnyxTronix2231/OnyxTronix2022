package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.climber.Climber;
import java.util.function.DoubleSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.*;

public class ClimbLevel extends SequentialCommandGroup {

    public ClimbLevel(Climber climber, DoubleSupplier speedSupplier) {
        super(new MoveRailUntilConditions(climber, speedSupplier, climber::isOuterHallEffectClosed, OUTER_HALL_EFFECT),
                new MoveRailUntilConditions(climber, () -> -speedSupplier.getAsDouble(),
                        climber::isInnerHallEffectClosed, INNER_HALL_EFFECT),
                new MoveRailByDistance(climber, () -> DISCONNECT_DISTANCE));
    }
}
