package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.ClosePistons;
import frc.robot.climber.commands.OpenPistons;
import humanControls.JoystickAxis;

public class DeputeClimberOiBinder {

    public DeputeClimberOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid, JoystickAxis climb) {
        closeSolenoid.whileActiveOnce(new ClosePistons(climber));
        openSolenoid.whileActiveOnce(new OpenPistons(climber));
        climb.whileActiveContinuous(new ClimbBySpeed(climber, () -> -climb.getRawAxis()));
    }
}
