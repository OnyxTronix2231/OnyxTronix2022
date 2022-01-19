package frc.robot.turret.commands;

public enum CurrentGoal {

    goto180(1),
    goto180m(2),
    gotoMax(3),
    gotoMin(4);

    final int value;

    CurrentGoal(int value) {
        this.value = value;
    }
}
