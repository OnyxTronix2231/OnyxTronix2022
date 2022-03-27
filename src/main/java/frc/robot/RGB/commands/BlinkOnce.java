package frc.robot.RGB.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RGB.Color;

public class BlinkOnce extends SequentialCommandGroup {

    public BlinkOnce(Color color, double time) {
        super(new WaitCommand(time),
                new SetColor(color),
                new WaitCommand(time),
                new TurnOff());
    }
}