package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGB;

public class SetToBlue extends InstantCommand {

    public SetToBlue(RGB rgb) {
        super(rgb::setToBlue, rgb);
    }
}
