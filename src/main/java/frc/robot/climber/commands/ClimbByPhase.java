package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.DISCONNECT_DISTANCE;

public class ClimbByPhase extends ConditionalCommand {

    public static int phase = 0;

    public ClimbByPhase(Climber climber, DoubleSupplier distanceSupplier, DoubleSupplier secondDistanceSupplier,
                        DoubleSupplier speedSupplier) {
        super(new MoveArmByDistance(climber, distanceSupplier).
                        andThen(new MoveArmByDistance(climber, secondDistanceSupplier)),
                new MoveRailUntilConditions(climber, speedSupplier, climber::isOuterMicroSwitchPressed).
                        andThen(new MoveRailUntilConditions(climber, () -> -speedSupplier.getAsDouble(),
                                climber::isInnerMicroSwitchPressed)).andThen(new MoveRailByDistance(climber,
                                () -> DISCONNECT_DISTANCE)), () -> phase == 0);
    }

    @Override
    public void end(boolean interrupted) {
        phase = 1;
    }
}
