package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGB;
import frc.robot.rgb.RGBLights;

public class SetColor extends InstantCommand {

    public SetColor(RGBLights led, Colors color) {
        this(led, color.value.getRed(), color.value.getGreen(), color.value.getBlue());
    }

    public SetColor(RGBLights led, RGB rgb) {
        this(led, rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public SetColor(RGBLights led, int red, int green, int blue) {
        super(()-> led.setToColor(red, green, blue));
    }
}
