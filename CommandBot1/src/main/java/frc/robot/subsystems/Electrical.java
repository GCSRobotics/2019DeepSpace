/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.properties.*;

/**
 * Add your docs here.
 */
public class Electrical extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final PowerDistributionPanel pdp = new PowerDistributionPanel();

  public Electrical() {
    super("Electrical");
    //Initialize the cameras
    CameraServer.getInstance().startAutomaticCapture(RobotMap.DriveCamera);
    CameraServer.getInstance().startAutomaticCapture(RobotMap.HatchCamera);

    addChild("Power Distribution", pdp);
  }

  
@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
