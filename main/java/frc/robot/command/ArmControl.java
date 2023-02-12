package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.controller.XboxControl;
import frc.robot.main.Robot;

public class ArmControl extends CommandBase {
    protected XboxControl xbox = Robot.xbox;

    @Override
    public void execute() {
        Robot.arms.updatePos(xbox.getRightX(), xbox.getRightY());
        Robot.arms.move();
        
        // Emergency Stop!
        xbox.getController().a().onTrue(Commands.runOnce(() -> { emergencyStop(); }));

        // Debugging purposes only
        Robot.arms.debug();
    }

    public void emergencyStop() {
        Robot.arms.emergencyStop();
    }
}
