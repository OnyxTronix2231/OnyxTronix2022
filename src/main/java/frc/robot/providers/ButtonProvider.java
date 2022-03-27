package frc.robot.providers;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public class ButtonProvider {

    private final Trigger releaseTrigger;
    private boolean clickedRelease = false;

    public ButtonProvider(Trigger releaseTrigger) {
        this.releaseTrigger = releaseTrigger;
    }

    public void setClickedRelease(boolean clickedRelease) {
        this.clickedRelease = clickedRelease;
    }

    public boolean getClickedRelease() {
        return clickedRelease;
    }
}
