package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.rgb.commands.*;

public class LedShuffleBoard {

    private RGBLights led;

    public void init() {
        Shuffleboard.getTab("RGBLights").add("SetBlue", new SetColor(led, Colors.blue));
        Shuffleboard.getTab("RGBLights").add("SetGreen", new SetColor(led, Colors.green));
        Shuffleboard.getTab("RGBLights").add("SetPurple", new SetColor(led, Colors.purple));
        Shuffleboard.getTab("RGBLights").add("SetYellow", new SetColor(led, Colors.yellow));
        Shuffleboard.getTab("RGBLights").add("SetOrange", new SetColor(led, Colors.orange));
        Shuffleboard.getTab("RGBLights").add("SetRed", new SetColor(led, Colors.red));
        Shuffleboard.getTab("RGBLights").add("setRainbow", new SetToRainbow(led));
        Shuffleboard.getTab("RGBLights").add("setToHalf", new Halfsies(led, Colors.red, Colors.blue));
        Shuffleboard.getTab("RGBLights").add("turnOff", new TurnOff(led));
        Shuffleboard.getTab("RGBLights").add("blin", new BlinkYouStupidFatPigHeadedDick(led, Colors.red, 2));
        Shuffleboard.getTab("RGBLights").add("blink", new BlinkOnce(led, Colors.red, 1));
        Shuffleboard.getTab("RGBLights").add("blinkTimes", new BlinkNumTimes(led, Colors.red, 0.2, 4));
    }
}
