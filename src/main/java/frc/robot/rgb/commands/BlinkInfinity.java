package frc.robot.rgb.commands;

import frc.robot.rgb.Colors;

public class BlinkInfinity extends BlinkOnce {

    public BlinkInfinity(Colors color, double time) {
        super(color, time);
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()) {
            initialize();
        }
        return false;
    }
}
