package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.controller.XboxControl;
import frc.robot.main.Robot;

public class UpdateLED extends CommandBase {
    protected XboxControl xbox = Robot.xbox;
    int curPattern = 0;

    @Override
    public void execute() {
        // Emergency Stop!
        xbox.getController().b().onTrue(Commands.runOnce(() -> { setPattern(); }));
    }

    public void setPattern() {
        Robot.leds.setLEDs(curPattern);
        curPattern++;
        curPattern %= 4;
    }
}
