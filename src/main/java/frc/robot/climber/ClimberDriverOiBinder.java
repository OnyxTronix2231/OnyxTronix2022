package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClosePistons;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.OpenPistons;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberDriverOiBinder {

    public ClimberDriverOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid,
                                 Trigger openArms, Trigger closeArms) {
        closeSolenoid.whileActiveOnce(new ClosePistons(climber));
        openSolenoid.whileActiveOnce(new OpenPistons(climber));
        openArms.whileActiveContinuous(new ClimbBySpeed(climber, () -> OPEN_CLIMBER_SPEED));
        closeArms.whileActiveContinuous(new ClimbBySpeed(climber, () -> CLOSE_CLIMBER_SPEED));
    }
}
