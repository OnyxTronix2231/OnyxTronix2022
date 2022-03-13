package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class Halfsies extends InstantCommand {

    public Halfsies(RGBLights rgb, Colors color1, Colors color2) {
        super(() -> rgb.halfsies(color1.value, color2.value), rgb);
    }
}
