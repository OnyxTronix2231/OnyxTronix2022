package frc.robot.RGB.logicCommands;

import frc.robot.RGB.OnyxRGB;
import frc.robot.RGB.commands.SetColor;

import static frc.robot.RGB.logicCommands.LogicRGBConstants.*;

public class RGB_DefaultStaticColor extends SetColor {

    public RGB_DefaultStaticColor() {
        super(DEFAULT_COLOR);
        addRequirements(OnyxRGB.getInstance());
    }
}
