package frc.robot.climber;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.commands.*;
import humanControls.JoystickAxis;

import static frc.robot.climber.ClimberConstants.SLOW_ARM_SPEED;

public class DeputeClimberOiBinder {

    public DeputeClimberOiBinder(Climber climber, Trigger closeSolenoid, Trigger openSolenoid, JoystickAxis climb,
                                 Trigger moveRightArmSlow, Trigger moveLeftArmSlow) {
        closeSolenoid.whileActiveOnce(new ClosePistons(climber));
        openSolenoid.whileActiveOnce(new OpenPistons(climber));
        climb.whileActiveContinuous(new ClimbBySpeed(climber, () -> -climb.getRawAxis()));
        moveLeftArmSlow.whileActiveContinuous(new MoveLeftArmBySpeed(climber, () -> SLOW_ARM_SPEED));
        moveRightArmSlow.whileActiveContinuous(new MoveRightArmBySpeed(climber, () -> SLOW_ARM_SPEED));
    }
}
