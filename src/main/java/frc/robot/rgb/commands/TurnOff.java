package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.rgb.RGBLights;

public class TurnOff extends InstantCommand {

    public TurnOff() {
        super(() -> RGBLights.getInstance().turnOff());
    }
}
