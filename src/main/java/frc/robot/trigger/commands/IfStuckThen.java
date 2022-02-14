package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.trigger.BallTrigger;

public class IfStuckThen extends SequentialCommandGroup {

    public IfStuckThen(BallTrigger ballTrigger, Command command){
        super(new UntilStuck(ballTrigger,command), new TriggerMoveBySpeed(ballTrigger, ()->-0.15));
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
