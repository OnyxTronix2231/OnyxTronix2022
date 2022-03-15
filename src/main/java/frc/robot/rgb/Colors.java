package frc.robot.rgb;

public enum Colors {
    red(new RGB(255, 0, 0)),
    green(new RGB(0, 255, 0)),
    blue(new RGB(0, 0, 255)),
    purple(new RGB(150, 0, 150)),
    orange(new RGB(255, 128, 0)),
    yellow(new RGB(255, 220, 0)),
    teal(new RGB(0, 255, 255)),
    pink(new RGB(255, 0, 127)),
    grey(new RGB(96, 96, 96)),
    black(new RGB(0, 0, 0)),
    white(new RGB(255, 255, 255));

    public final RGB value;

    Colors(RGB value) {
        this.value = value;
    }
}
