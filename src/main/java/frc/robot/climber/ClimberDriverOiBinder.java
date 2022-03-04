package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClosePistons;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.OpenPistons;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid,
                                 Trigger moveForward, Trigger moveBackwards) {
        closeSolenoid.whileActiveOnce(new ClosePistons(climber));
        openSolenoid.whileActiveOnce(new OpenPistons(climber));
        moveBackwards.whileActiveContinuous(new ClimbBySpeed(climber, ()->0.8));
        moveForward.whileActiveContinuous(new ClimbBySpeed(climber, ()->0.8));
    }
}
