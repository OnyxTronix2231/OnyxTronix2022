package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.climber.Climber;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.WaitUntilClimbedByEncoder;

import java.util.function.DoubleSupplier;

public class ClimbUntilConditions extends ParallelDeadlineGroup {

    public ClimbUntilConditions(Climber climber, AdvancedClimber advancedClimber, DoubleSupplier speedSupplier) {
        super(new WaitUntilClimbedByEncoder(climber).alongWith(new WaitUntilClimbedByPitch(advancedClimber)),
                new ClimbBySpeed(climber, speedSupplier));
    }
}
