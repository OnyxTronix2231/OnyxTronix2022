package frc.robot.climber.commands;

import static frc.robot.climber.commands.ClimberCommandConstants.DISCONNECT_DISTANCE;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class ClimbByPhase extends ConditionalCommand {

    public static int phase = 0;

    public ClimbByPhase(Climber climber, DoubleSupplier distanceSupplier, DoubleSupplier secondDistanceSupplier,
                        DoubleSupplier speedSupplier) {
        super(new MoveArmByDistance(climber, distanceSupplier).
                andThen(new MoveArmByDistance(climber, secondDistanceSupplier)),
                new MoveRailUntilConditions(climber, speedSupplier, climber::isOuterMicroSwitchOpen).
                        andThen(new MoveRailUntilConditions(climber, () -> -speedSupplier.getAsDouble(),
                                climber::isInnerMicroSwitchOpen)).andThen(new MoveRailByDistance(climber,
                                () ->DISCONNECT_DISTANCE)), () -> phase == 0);
    }

    @Override
    public void end(boolean interrupted) {
        phase = 1;
    }
}
