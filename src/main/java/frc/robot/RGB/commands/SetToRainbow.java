package frc.robot.RGB.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RGB.Color;

public class SetToRainbow extends SequentialCommandGroup {

    public SetToRainbow(double time) {
        super(
                new SetColor(Color.Blue),
                new WaitCommand(time),
                new SetColor(Color.Green),
                new WaitCommand(time),
                new SetColor(Color.Red),
                new WaitCommand(time),
                new SetColor(Color.White),
                new WaitCommand(time),
                new SetColor(Color.Orange),
                new WaitCommand(time),
                new SetColor(Color.Purple)
        );
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }

}
