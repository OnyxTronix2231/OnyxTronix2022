package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBColor;
import frc.robot.rgb.RGBLights;

public class Halfsies extends InstantCommand {

    public Halfsies(Colors color1, Colors color2) {
        this(color1.value.getRed(), color1.value.getGreen(), color1.value.getBlue(),
                color2.value.getRed(), color2.value.getGreen(), color2.value.getBlue());
    }

    public Halfsies(RGBColor color1, RGBColor color2) {
        this(color1.getRed(), color1.getGreen(), color1.getBlue(),
                color2.getRed(), color2.getGreen(), color2.getBlue());
    }

    public Halfsies(int red1, int green1, int blue1, int red2, int green2, int blue2) {
        super(() -> RGBLights.getInstance().halfsies(red1, green1, blue1, red2, green2, blue2));
    }
}
