package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.climber.Climber;
import java.util.function.DoubleSupplier;

public class MoveArmsByDistance extends ParallelCommandGroup {

    public MoveArmsByDistance(Climber climber, DoubleSupplier distanceSupplier) {
        super(
                new MoveLeftArmByDistance(climber, distanceSupplier),
                new MoveRightArmByDistance(climber,distanceSupplier)
        );
    }
}
