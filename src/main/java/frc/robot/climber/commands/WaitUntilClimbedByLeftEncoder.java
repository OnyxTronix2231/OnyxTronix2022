package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

public class WaitUntilClimbedByLeftEncoder extends CommandBase {

    private final Climber climber;

    public WaitUntilClimbedByLeftEncoder(Climber climber) {
        this.climber = climber;
    }

    @Override
    public boolean isFinished() {
        return climber.isLeftEncoderOnTarget();
    }
}
