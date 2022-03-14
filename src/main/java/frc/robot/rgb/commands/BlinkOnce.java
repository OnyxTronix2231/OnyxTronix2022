package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class BlinkOnce extends SequentialCommandGroup {

    public BlinkOnce(RGBLights led, Colors color, double time) {
        super(new WaitCommand(time),
                new SetColor(led, color),
                new WaitCommand(time),
                new TurnOff(led));
    }
}
