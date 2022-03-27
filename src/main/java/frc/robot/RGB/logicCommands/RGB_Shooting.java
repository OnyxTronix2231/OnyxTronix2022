package frc.robot.RGB.logicCommands;

import frc.robot.RGB.commands.BlinkInfinity;

import static frc.robot.RGB.logicCommands.LogicRGBConstants.*;

public class RGB_Shooting extends BlinkInfinity {

    public RGB_Shooting() {
        super(SHOOTING_CLR, SHOOTING_BLINK_TIME);
    }
}
