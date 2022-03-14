package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGBLights;

public class SetToRainbow extends InstantCommand {

    public SetToRainbow(RGBLights led) {
        super(led::rainbow);
    }
}
