package frc.robot.rgb.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.rgb.Colors;
import frc.robot.rgb.RGBLights;

public class BlinkYouStupidFatPigHeadedDick extends SequentialCommandGroup {

    public BlinkYouStupidFatPigHeadedDick(Colors color, double time) {
        super(new SetColor(color), new WaitCommand(time), new TurnOff(), new WaitCommand(time));
    }

    @Override
    public boolean isFinished() {
        if(super.isFinished()) {
            initialize();
        }
        return false;
    }
}
