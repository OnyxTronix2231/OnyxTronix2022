package frc.robot.rgb.commands;

import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class TurnOff extends SetColor {

    public TurnOff(RGBLights led) {
        super(led, Colors.black);
    }
}
