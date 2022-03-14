package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.rgb.commands.*;

public class LedShuffleBoard {

    public void init() {
        Shuffleboard.getTab("RGBLights").add("SetBlue", new SetColor(Colors.blue));
        Shuffleboard.getTab("RGBLights").add("SetGreen", new SetColor(Colors.green));
        Shuffleboard.getTab("RGBLights").add("SetPurple", new SetColor(Colors.purple));
        Shuffleboard.getTab("RGBLights").add("SetYellow", new SetColor(Colors.yellow));
        Shuffleboard.getTab("RGBLights").add("SetOrange", new SetColor(Colors.orange));
        Shuffleboard.getTab("RGBLights").add("SetRed", new SetColor(Colors.red));
        Shuffleboard.getTab("RGBLights").add("setRainbow", new SetToRainbow());
        Shuffleboard.getTab("RGBLights").add("setToHalf", new Halfsies(Colors.red, Colors.blue));
        Shuffleboard.getTab("RGBLights").add("turnOff", new TurnOff());
        Shuffleboard.getTab("RGBLights").add("blin", new BlinkYouStupidFatPigHeadedDick(Colors.red, 2));
        Shuffleboard.getTab("RGBLights").add("blink", new BlinkOnce(Colors.red, 1));
        Shuffleboard.getTab("RGBLights").add("blinkTimes", new BlinkNumTimes(Colors.red, 0.2, 4));
    }
}
