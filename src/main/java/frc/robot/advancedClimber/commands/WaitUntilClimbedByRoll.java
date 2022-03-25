package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;

public class WaitUntilClimbedByRoll extends CommandBase {

    private final AdvancedClimber advancedClimber;

    public WaitUntilClimbedByRoll(AdvancedClimber advancedClimber) {
        this.advancedClimber = advancedClimber;
        addRequirements(advancedClimber);
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isOnDesiredRollAngle();
    }
}
