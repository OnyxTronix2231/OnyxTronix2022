package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.DISCONNECT_DISTANCE;
import static frc.robot.climber.commands.ClimberCommandConstants.DISTANCE_BETWEEN_BEAMS;

public class ClimbByPhase extends ConditionalCommand {

    public static boolean phase = true;

    public ClimbByPhase(Climber climber, DoubleSupplier distanceSupplier, DoubleSupplier closingDistanceSupplier,
                        DoubleSupplier speedSupplier) {
        super(new MoveArmByDistance(climber, distanceSupplier).
                        andThen(new MoveArmByDistance(climber, closingDistanceSupplier)),
                new MoveRailByDistance(climber, () -> DISTANCE_BETWEEN_BEAMS).
                        andThen(new MoveRailUntilConditions(climber, () -> -speedSupplier.getAsDouble(),
                                climber::isInnerHallEffectClosed)).andThen(new MoveRailByDistance(climber,
                                () -> DISCONNECT_DISTANCE)), () -> phase);
    }

    @Override
    public void end(boolean interrupted) {
        phase = false;
    }
}
