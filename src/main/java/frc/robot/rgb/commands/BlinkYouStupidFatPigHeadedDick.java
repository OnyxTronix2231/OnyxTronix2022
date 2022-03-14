package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class BlinkYouStupidFatPigHeadedDick extends SequentialCommandGroup {

    public BlinkYouStupidFatPigHeadedDick(RGBLights rgb, Colors color) {
        super(new SetToRainbow(rgb), new WaitCommand(0.5), new TurnOff(rgb), new WaitCommand(0.5), new SetToRainbow(rgb), new WaitCommand(0.5), new TurnOff(rgb), new WaitCommand(0.5), new SetToRainbow(rgb), new WaitCommand(0.5), new TurnOff(rgb));
    }
}
