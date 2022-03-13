package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGB;

public class SetToRed extends InstantCommand {

    public SetToRed(RGB rgb) {
        super(rgb::setToRed, rgb);
    }
}
