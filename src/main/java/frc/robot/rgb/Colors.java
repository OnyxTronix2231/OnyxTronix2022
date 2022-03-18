package frc.robot.rgb;

public enum Colors {
    red(new RGBColor(255, 0, 0)),
    green(new RGBColor(0, 255, 0)),
    blue(new RGBColor(0, 0, 255)),
    purple(new RGBColor(150, 0, 150)),
    orange(new RGBColor(255, 128, 0)),
    yellow(new RGBColor(255, 220, 0)),
    teal(new RGBColor(0, 255, 255)),
    pink(new RGBColor(255, 0, 127)),
    grey(new RGBColor(96, 96, 96)),
    black(new RGBColor(0, 0, 0)),
    white(new RGBColor(255, 255, 255));

    public final RGBColor value;

    Colors(RGBColor value) {
        this.value = value;
    }
}
