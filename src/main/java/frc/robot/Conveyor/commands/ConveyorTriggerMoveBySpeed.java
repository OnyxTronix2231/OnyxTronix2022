package frc.robot.Conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import 

public class ConveyorTriggerMoveBySpeed extends CommandBase {

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        triggerBySpeed();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}
