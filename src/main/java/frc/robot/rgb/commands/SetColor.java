package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class SetColor extends InstantCommand {

    public SetColor(RGBLights rgb, Colors color) {
        super(() -> rgb.setToColor(color.value), rgb);
    }
}
