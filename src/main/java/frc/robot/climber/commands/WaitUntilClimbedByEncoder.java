package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.climber.Climber;

public class WaitUntilClimbedByEncoder extends ParallelCommandGroup {

    public WaitUntilClimbedByEncoder(Climber climber) {
        super(new WaitUntilClimbedByLeftEncoder(climber), new WaitUntilClimbedByRightEncoder(climber));
    }
}
