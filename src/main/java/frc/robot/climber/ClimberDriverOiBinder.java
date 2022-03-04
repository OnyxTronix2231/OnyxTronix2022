package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClosePistons;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.OpenPistons;
import humanControls.JoystickAxis;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid,
                                 JoystickAxis openArms) {
        closeSolenoid.whileActiveOnce(new ClosePistons(climber));
        openSolenoid.whileActiveOnce(new OpenPistons(climber));
        openArms.whileActiveContinuous(new ClimbBySpeed(climber, openArms::getRawAxis));
    }
}
