package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.CloseSolenoid;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.OpenSolenoid;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid,
                                 Trigger moveForward, Trigger moveBackwards) {
        closeSolenoid.whileActiveOnce(new CloseSolenoid(climber));
        openSolenoid.whileActiveOnce(new OpenSolenoid(climber));
        moveBackwards.whileActiveContinuous(new ClimbBySpeed(climber, ()->0.8));
        moveForward.whileActiveContinuous(new ClimbBySpeed(climber, ()->0.8));
    }
}
