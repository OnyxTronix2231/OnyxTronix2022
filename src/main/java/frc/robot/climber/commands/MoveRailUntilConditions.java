package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class MoveRailUntilConditions extends ParallelDeadlineGroup {
    public MoveRailUntilConditions(Climber climber, DoubleSupplier speedSupplier, BooleanSupplier isMicroSwitchClosed) {
        super(new WaitUntilHallEffect(isMicroSwitchClosed),
                new MoveRailBySpeed(climber, speedSupplier));
    }
}
