package frc.robot.RGB.logicCommands;

import frc.robot.RGB.commands.BlinkInfinity;
import frc.robot.RGB.commands.SetColor;

import static frc.robot.RGB.logicCommands.LogicRGBConstants.DEFAULT_BLINK_TIME;
import static frc.robot.RGB.logicCommands.LogicRGBConstants.TARGET_LOCATE_CLR;

public class RGB_FoundTarget extends SetColor {

    public RGB_FoundTarget() {
        super(TARGET_LOCATE_CLR);
    }
}
