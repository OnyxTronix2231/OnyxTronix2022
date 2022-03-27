package frc.robot.RGB;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.RGB.commands.SetColor;

public class RGBShuffleboard {

    public RGBShuffleboard() {
        Shuffleboard.getTab("RGBLights").add("Set Red", new SetColor(Color.Red));
        Shuffleboard.getTab("RGBLights").add("Set Green", new SetColor(Color.Green));
        Shuffleboard.getTab("RGBLights").add("Set Blue", new SetColor(Color.Blue));
        Shuffleboard.getTab("RGBLights").add("Set Purple", new SetColor(Color.Purple));
        Shuffleboard.getTab("RGBLights").add("Set Yellow", new SetColor(Color.Yellow));
        Shuffleboard.getTab("RGBLights").add("Set Orange", new SetColor(Color.Orange));
        Shuffleboard.getTab("RGBLights").add("Set White", new SetColor(Color.White));
        Shuffleboard.getTab("RGBLights").add("Set Pink", new SetColor(Color.Pink));
        Shuffleboard.getTab("RGBLights").add("Turn Off", new SetColor(Color.Black));
    }
}
