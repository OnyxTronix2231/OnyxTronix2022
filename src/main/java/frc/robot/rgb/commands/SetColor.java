package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGB;
import frc.robot.rgb.RGBLights;

public class SetColor extends InstantCommand {

    public SetColor(Colors color) {
        this(color.value[0], color.value[1], color.value[2]);
    }

    public SetColor(RGB rgb) {
        this(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public SetColor(int red, int green, int blue) {
        super(()-> RGBLights.getInstance().setToColor(red, green, blue));
    }
}
