package frc.robot.RGB.logicCommands;

import frc.robot.RGB.commands.BlinkInfinity;

import static frc.robot.RGB.logicCommands.LogicRGBConstants.*;

public class RGB_ActiveIntake extends BlinkInfinity {

    public RGB_ActiveIntake() {
        super(ACTIVE_INTAKE_CLR, INTAKE_BLINK_TIME);
    }
}
