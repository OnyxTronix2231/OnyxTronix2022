package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGB;

public class Halfsies extends InstantCommand {

    public Halfsies(RGB rgb) {
        super(rgb::halfsies, rgb);
    }
}
