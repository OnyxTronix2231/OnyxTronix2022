package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.rgb.commands.*;

public class LedShuffleBoard {

    private RGB rgb;

    public LedShuffleBoard(RGB rgb) {
        this.rgb = rgb;
    }

    public void init() {
        Shuffleboard.getTab("RGB").add("setRed", new SetToRed(rgb));
        Shuffleboard.getTab("RGB").add("setGreen", new SetToGreen(rgb));
        Shuffleboard.getTab("RGB").add("setBlue", new SetToBlue(rgb));
        Shuffleboard.getTab("RGB").add("setRainbow", new SetToRainbow(rgb));
        Shuffleboard.getTab("RGB").add("setToHalf", new Halfsies(rgb));
    }
}
