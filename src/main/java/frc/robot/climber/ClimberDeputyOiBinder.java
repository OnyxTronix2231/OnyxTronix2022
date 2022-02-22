package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.ClimbByPhase;
import frc.robot.climber.commands.MoveRailBySpeed;
import humanControls.JoystickAxis;

import static frc.robot.climber.ClimberConstants.PERCENT_OUTPUT;

public class ClimberDeputyOiBinder {

    public ClimberDeputyOiBinder(final Climber climber, final JoystickAxis moveRail) {
        moveRail.whileActiveContinuous( new MoveRailBySpeed(climber, () -> moveRail.getRawAxis() * 0.8));
    }
}
