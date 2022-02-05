package frc.robot.loader.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.loader.Loader;

public class IfStuckThen extends SequentialCommandGroup {

    public IfStuckThen(Loader loader, Command command){
        super(new UntilStuck(loader,command), new LoaderMoveBySpeed(loader, ()->-0.15));
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
