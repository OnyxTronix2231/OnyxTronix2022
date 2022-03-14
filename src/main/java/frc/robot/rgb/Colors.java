package frc.robot.rgb;

public enum Colors {
    red(new int[]{255, 0, 0}),
    green(new int[]{0, 255, 0}),
    blue(new int[]{0, 0, 255}),
    purple(new int[]{150, 0, 150}),
    orange(new int[]{255, 128, 0}),
    yellow(new int[]{255, 220, 0}),
    teal(new int[]{0, 255, 255}),
    pink(new int[]{255, 0, 127}),
    grey(new int[]{96, 96, 96}),
    black(new int[]{0, 0, 0}),
    white(new int[]{255, 255, 255});

    public final int[] value;

    Colors(int[] value) {
        this.value = value;
    }
}
