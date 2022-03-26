package frc.robot.RGB.commands;

import frc.robot.RGB.Color;

public class BlinkInfinity extends BlinkOnce {

    public BlinkInfinity(Color color, double time) {
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