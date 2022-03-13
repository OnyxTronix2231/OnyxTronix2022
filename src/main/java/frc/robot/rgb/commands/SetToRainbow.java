package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGB;

public class SetToRainbow extends InstantCommand {

    public SetToRainbow(RGB rgb) {
        super(rgb::rainbow, rgb);
    }
}
