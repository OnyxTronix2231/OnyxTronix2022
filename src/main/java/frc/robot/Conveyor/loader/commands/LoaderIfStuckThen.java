package frc.robot.Conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Conveyor.loader.Loader;

public class LoaderIfStuckThen extends SequentialCommandGroup {

    public LoaderIfStuckThen(Loader loader, Command command){
        super(new LoaderDoUntilStuck(loader,command), new LoaderMoveBySpeed(loader, ()->-0.15));

    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
