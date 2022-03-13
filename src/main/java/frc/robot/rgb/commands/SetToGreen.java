package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGB;

public class SetToGreen extends InstantCommand {

    public SetToGreen(RGB rgb) {
        super(rgb::setToGreen, rgb);
    }
}
