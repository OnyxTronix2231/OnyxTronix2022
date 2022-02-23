package frc.robot.climber.commands;

import frc.robot.climber.Climber;

import static frc.robot.climber.commands.ClimberCommandConstants.MOVE_ARMS_TO_LIMIT_SWITCH_SPEED;

public class MoveArmsToLimitSwitch extends MoveArmBySpeed {

    public MoveArmsToLimitSwitch(Climber climber) {
        super(climber, () -> MOVE_ARMS_TO_LIMIT_SWITCH_SPEED);
    }

    @Override
    public boolean isFinished() {
        return climber.areArmsAtLimitSwitch();
    }
}
