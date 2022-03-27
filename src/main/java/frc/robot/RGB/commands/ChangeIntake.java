package frc.robot.RGB.commands;

import edu.wpi.first.wpilibj2.command.*;

import java.util.function.BooleanSupplier;

public class ChangeIntake extends ParallelRaceGroup {

    public ChangeIntake(Command onTrue, Command onFalse, BooleanSupplier condition) {
        super(new WaitCommand(0.1), new ConditionalCommand(onTrue, onFalse, condition));
    }

    @Override
    public void end(boolean interrupted) {
        if(isFinished()) {
            System.out.println("Done again");
            initialize();
        }
    }
}
