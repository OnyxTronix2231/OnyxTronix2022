package frc.robot.rgb.commands;

import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class BlinkNumTimes extends BlinkOnce {

    private final int repeat;
    private int counter;

    public BlinkNumTimes(Colors color, double time, int repeat) {
        super(color, time);
        this.repeat = repeat;
        counter = repeat;
    }

    @Override
    public void initialize() {
         counter = repeat;
         super.initialize();
    }

    @Override
    public boolean isFinished() {
        if (super.isFinished()){
            counter--;
            System.out.println(counter);
            super.initialize();
        }
        return counter == 0;
    }
}
