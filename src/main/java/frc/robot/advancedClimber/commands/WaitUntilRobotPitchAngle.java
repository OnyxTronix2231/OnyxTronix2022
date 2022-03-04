package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.climber.Climber;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class WaitUntilRobotPitchAngle extends CommandBase {

    private final AdvancedClimber advancedClimber;

    public WaitUntilRobotPitchAngle(AdvancedClimber advancedClimber) {
        this.advancedClimber = advancedClimber;
        addRequirements(advancedClimber);
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.hasReachedFourthBar();
    }
}
