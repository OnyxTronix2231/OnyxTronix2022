package frc.robot.RGB.logicCommands;

import frc.robot.RGB.commands.BlinkInfinity;

import static frc.robot.RGB.logicCommands.LogicRGBConstants.*;

public class RGB_SearchForTarget extends BlinkInfinity {

    public RGB_SearchForTarget() {
        super(TARGET_LOCATE_CLR, DEFAULT_BLINK_TIME);
    }
}
