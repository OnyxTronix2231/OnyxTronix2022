package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import static frc.robot.turret.TurretConstants.*;

public class RotateToUnseenVision extends CommandBase {
    private Turret turret;
    private CurrentGoal currentGoal;

    public RotateToUnseenVision(Turret turret){
        this.turret = turret;

        double angle = turret.getCurrentAngle();
        if (angle > 0 && angle <= (MIN_DEG + DEG_IN_ROTATION)){
            currentGoal = CurrentGoal.goto180;
        } else if (angle <= 0 && angle >= (MAX_DEG - DEG_IN_ROTATION)){
            currentGoal = CurrentGoal.goto180m;
        } else if (angle >= (MIN_DEG + DEG_IN_ROTATION)){
            currentGoal = CurrentGoal.gotoMin;
        } else if (angle <= (MAX_DEG - DEG_IN_ROTATION)){
            currentGoal = CurrentGoal.gotoMax;
        }
    }

    @Override
    public void initialize() {
        switch (currentGoal){
            case goto180: turret.initMoveToDegree(180);
            case goto180m: turret.initMoveByDegree(-180);
            case gotoMax: turret.initMoveByDegree(MAX_DEG);
            case gotoMin: turret.initMoveByDegree(MIN_DEG);
        }
    }

    @Override
    public void execute() {
        switch (currentGoal){
            case goto180:
                if (Math.abs(turret.getCurrentAngle() - 180) <= TOLERANCE_DEGREE){
                    currentGoal = CurrentGoal.gotoMin;
                } else { turret.updateMoveToDegree(180);}

            case goto180m:
                if ((Math.abs(turret.getCurrentAngle()) + 180) <= TOLERANCE_DEGREE){
                    currentGoal = CurrentGoal.gotoMax;
                } else { turret.updateMoveByDegree(-180);}

            case gotoMax:
                if (Math.abs(turret.getCurrentAngle() - MAX_DEG) <= TOLERANCE_DEGREE){
                    currentGoal = CurrentGoal.gotoMin;
                } else { turret.updateMoveToDegree(MAX_DEG);}

            case gotoMin:
                if (Math.abs(turret.getCurrentAngle() - MIN_DEG) <= TOLERANCE_DEGREE){
                    currentGoal = CurrentGoal.gotoMax;
                } else { turret.updateMoveToDegree(MIN_DEG);}
        }
    }
}

enum CurrentGoal{
    goto180(1),
    goto180m(2),
    gotoMax(3),
    gotoMin(4);

    final int value;

    CurrentGoal(int value){
        this.value = value;
    }
}
