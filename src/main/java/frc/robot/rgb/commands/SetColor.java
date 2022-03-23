package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBColor;
import frc.robot.rgb.RGBLights;

public class SetColor extends InstantCommand {

    public SetColor(Colors color) {
        this(color.value.getRed(), color.value.getGreen(), color.value.getBlue());
    }

    public SetColor(RGBColor rgbColor) {
        this(rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue());
    }

    public SetColor(int red, int green, int blue) {
        super(()-> RGBLights.getInstance().setToColor(red, green, blue));
    }
}
