package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.loader.Loader;
import frc.robot.loader.commands.LoaderMoveBySpeed;
import frc.robot.trigger.Triggerr;

public class IfStuckThen extends SequentialCommandGroup {

    public IfStuckThen(Triggerr triggerr, Command command){
        super(new UntilStuck(triggerr,command), new TriggerMoveBySpeed(triggerr, ()->-0.15));
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
