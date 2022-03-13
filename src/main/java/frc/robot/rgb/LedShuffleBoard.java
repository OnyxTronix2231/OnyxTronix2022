package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.rgb.commands.SetToBlue;
import frc.robot.rgb.commands.SetToGreen;
import frc.robot.rgb.commands.SetToRed;

public class LedShuffleBoard {

    private RGB rgb;

    public LedShuffleBoard(RGB rgb) {
        this.rgb = rgb;
    }

    public void init() {
        Shuffleboard.getTab("RGB").add("setRed", new SetToRed(rgb));
        Shuffleboard.getTab("RGB").add("setGreen", new SetToGreen(rgb));
        Shuffleboard.getTab("RGB").add("setBlue", new SetToBlue(rgb));
    }
}
