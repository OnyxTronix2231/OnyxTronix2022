package frc.robot.rgb;

public enum Colors {
    red(new int[]{255, 0, 0}),
    green(new int[]{0, 255, 0}),
    blue(new int[]{0, 0, 255}),
    purple(new int[]{150, 0, 150}),
    orange(new int[]{255, 128, 0}),
    yellow(new int[]{255, 220, 0});

    public final int[] value;

    Colors(int[] value) {
        this.value = value;
    }
}
