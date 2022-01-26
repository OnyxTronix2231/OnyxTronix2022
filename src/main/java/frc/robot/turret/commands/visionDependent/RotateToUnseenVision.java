package frc.robot.turret.commands.visionDependent;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import static frc.robot.turret.TurretConstants.*;

public class RotateToUnseenVision extends CommandBase {

    private final Turret turret;
    private CurrentGoal currentGoal;

    public RotateToUnseenVision(Turret turret) {
        this.turret = turret;

        double angle = turret.getCurrentAngle();
        if (angle > MIDDLE_ANGLE && angle <= (MIN_DEG + DEG_IN_CIRCLE)) {
            currentGoal = CurrentGoal.goto180;
        } else if (angle <= MIDDLE_ANGLE && angle >= (MAX_DEG - DEG_IN_CIRCLE)) {
            currentGoal = CurrentGoal.goto180m;
        } else if (angle >= (MIN_DEG + DEG_IN_CIRCLE)) {
            currentGoal = CurrentGoal.gotoMin;
        } else if (angle <= (MAX_DEG - DEG_IN_CIRCLE)) {
            currentGoal = CurrentGoal.gotoMax;
        }

        addRequirements(turret);
    }

    @Override
    public void initialize() {
        switch (currentGoal) {
            case goto180: turret.initMoveToDegree(HALF_ROTATION);
            case goto180m: turret.initMoveByDegree(-HALF_ROTATION);
            case gotoMax: turret.initMoveByDegree(MAX_DEG);
            case gotoMin: turret.initMoveByDegree(MIN_DEG);
        }
    }

    @Override
    public void execute() {
        switch (currentGoal) {
            case goto180:
                if (Math.abs(turret.getCurrentAngle() - HALF_ROTATION) <= TOLERANCE_DEGREE) {
                    currentGoal = CurrentGoal.gotoMin;
                } else {
                    turret.updateMoveToDegree(HALF_ROTATION);
                }
            case goto180m:
                if ((Math.abs(turret.getCurrentAngle()) + HALF_ROTATION) <= TOLERANCE_DEGREE) {
                    currentGoal = CurrentGoal.gotoMax;
                } else {
                    turret.updateMoveByDegree(-HALF_ROTATION);
                }
            case gotoMax:
                if (Math.abs(turret.getCurrentAngle() - MAX_DEG) <= TOLERANCE_DEGREE) {
                    currentGoal = CurrentGoal.gotoMin;
                } else {
                    turret.updateMoveToDegree(MAX_DEG);
                }
            case gotoMin:
                if (Math.abs(turret.getCurrentAngle() - MIN_DEG) <= TOLERANCE_DEGREE) {
                    currentGoal = CurrentGoal.gotoMax;
                } else {
                    turret.updateMoveToDegree(MIN_DEG);
                }
        }
    }
}