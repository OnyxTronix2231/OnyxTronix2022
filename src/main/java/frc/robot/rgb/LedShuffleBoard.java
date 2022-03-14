package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.rgb.commands.*;

public class LedShuffleBoard {

    private final RGBLights rgb;

    public LedShuffleBoard(RGBLights rgb) {
        this.rgb = rgb;
    }

    public void init() {
        Shuffleboard.getTab("RGBLights").add("SetBlue", new SetColor(rgb, Colors.blue));
        Shuffleboard.getTab("RGBLights").add("SetGreen", new SetColor(rgb, Colors.green));
        Shuffleboard.getTab("RGBLights").add("SetPurple", new SetColor(rgb, Colors.purple));
        Shuffleboard.getTab("RGBLights").add("SetYellow", new SetColor(rgb, Colors.yellow));
        Shuffleboard.getTab("RGBLights").add("SetOrange", new SetColor(rgb, Colors.orange));
        Shuffleboard.getTab("RGBLights").add("SetRed", new SetColor(rgb, Colors.red));
        Shuffleboard.getTab("RGBLights").add("setRainbow", new SetToRainbow(rgb));
        Shuffleboard.getTab("RGBLights").add("setToHalf", new Halfsies(rgb, Colors.red, Colors.blue));
        Shuffleboard.getTab("RGBLights").add("turnOff", new TurnOff(rgb));
        Shuffleboard.getTab("RGBLights").add("blin", new BlinkYouStupidFatPigHeadedDick(rgb, Colors.red));
        Shuffleboard.getTab("RGBLights").add("blink", new Blink(rgb, Colors.red, 9));
    }
}
