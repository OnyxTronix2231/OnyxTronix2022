package frc.robot.rgb;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.rgb.commands.*;

public class LedShuffleBoard {

    private final RGBLights rgb;
    private SendableChooser<Colors> colorChooser;

    public LedShuffleBoard(RGBLights rgb) {
        this.rgb = rgb;
    }

    public void init() {
        colorChooser = new SendableChooser<>();
        colorChooser.addOption("red", Colors.red);
        colorChooser.addOption("green",Colors.green);
        colorChooser.addOption("blue", Colors.blue);
        colorChooser.addOption("red", Colors.red);
        Shuffleboard.getTab("RGBLights").add(colorChooser);
        Shuffleboard.getTab("RGBLights").add("SetToColor", new SetColor(rgb, colorChooser.getSelected()));







//        Shuffleboard.getTab("RGBLights").add("SetBlue", new SetColor(rgb, Colors.blue));
//        Shuffleboard.getTab("RGBLights").add("SetGreen", new SetColor(rgb, Colors.green));
//        Shuffleboard.getTab("RGBLights").add("SetPurple", new SetColor(rgb, Colors.purple));
//        Shuffleboard.getTab("RGBLights").add("SetYellow", new SetColor(rgb, Colors.yellow));
//        Shuffleboard.getTab("RGBLights").add("SetOrange", new SetColor(rgb, Colors.orange));
//        Shuffleboard.getTab("RGBLights").add("SetColor", new SetColor(rgb, Colors.red));
//        Shuffleboard.getTab("RGBLights").add("setRainbow", new SetToRainbow(rgb));
//        Shuffleboard.getTab("RGBLights").add("setToHalf", new Halfsies(rgb, Colors.red, Colors.blue));
    }
}
