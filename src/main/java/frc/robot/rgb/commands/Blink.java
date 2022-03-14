package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class Blink extends CommandBase {

    private RGBLights rgb;
    private Colors color;
    private int repeat;

    public Blink(RGBLights rgb, Colors color, int repeat) {
        this.rgb = rgb;
        this.color = color;
        this.repeat = repeat;
    }

    public void execute() {
        for (int i = 0; i < repeat; i++) {
            new BlinkYouStupidFatPigHeadedDick(rgb, color);
        }
    }
}
