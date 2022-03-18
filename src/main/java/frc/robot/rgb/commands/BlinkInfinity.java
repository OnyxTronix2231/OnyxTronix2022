package frc.robot.rgb.commands;

import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class BlinkInfinity extends BlinkOnce {

    public BlinkInfinity(RGBLights led, Colors color, double time) {
        super(led, color, time);
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
