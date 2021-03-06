/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.Enums;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

  //CAN Bus Controllers
  private final WPI_VictorSPX leftFrontCtrl = new WPI_VictorSPX(1);
  private final WPI_VictorSPX leftRearCtrl = new WPI_VictorSPX(2);
  private final WPI_VictorSPX rightFrontCtrl = new WPI_VictorSPX(3);
  private final WPI_VictorSPX rightRearCtrl = new WPI_VictorSPX(4);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftFrontCtrl, rightFrontCtrl);

  //PWM Controllers
  // private final SpeedControllerGroup speedControllerGroupleft = 
  //     new SpeedControllerGroup(new PWMVictorSPX(0), new PWMVictorSPX(1));
  // private final SpeedControllerGroup speedControllerGroupright = 
  //     new SpeedControllerGroup(new PWMVictorSPX(2), new PWMVictorSPX(3));
  // private final DifferentialDrive m_robotDrive = 
  //     new DifferentialDrive(speedControllerGroupleft, speedControllerGroupright);
  
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

  PowerDistributionPanel pdp = new PowerDistributionPanel();

  private SendableChooser<Enums.DriveMode> chooser = new SendableChooser<Enums.DriveMode>();
  private Enums.DriveMode driveMode = null;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  // This is  comment. no its not
  @Override
  public void robotInit() {
    leftRearCtrl.follow(leftFrontCtrl);
    rightRearCtrl.follow(rightFrontCtrl); 

    CameraServer.getInstance().startAutomaticCapture(0);
    CameraServer.getInstance().startAutomaticCapture(1);

    chooser.setDefaultOption("Tank Drive", Enums.DriveMode.tank);
    chooser.addOption("Arcade (Single Stick)", Enums.DriveMode.arcadeSingle);
    chooser.addOption("Arcade (Double Stick)", Enums.DriveMode.arcadeDouble);

    SmartDashboard.putData(chooser);
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() 
  {
    driveMode = (Enums.DriveMode)chooser.getSelected();

  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Volts", pdp.getVoltage());
    SmartDashboard.putNumber("Motor 1 Current", pdp.getCurrent(0));

    switch(driveMode)
    {

      case arcadeSingle : m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX(), true);
        break;
      case arcadeDouble : m_robotDrive.arcadeDrive(m_stick.getRawAxis(1), m_stick.getRawAxis(4));
        break;
      case tank : m_robotDrive.tankDrive(m_stick.getRawAxis(1), m_stick.getRawAxis(5));
        break;

    }
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
 
  }


}



