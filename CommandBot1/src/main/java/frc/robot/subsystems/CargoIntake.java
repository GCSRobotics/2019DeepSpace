/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.properties.RobotMap;

/**
 * Add your docs here.
 */
public class CargoIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final SpeedController intakeMotor = new PWMVictorSPX(RobotMap.ConveyorMotor);
public CargoIntake() {
  super("Cargo Intake");
  addChild((PWMVictorSPX) intakeMotor);

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ForwardFullSpeed() {
    intakeMotor.set(1);
  }

  public void ReverseFullSpeed() {
    intakeMotor.set(-1);
  }

  public void ForwardHalfSpeed() {
    intakeMotor.set(.5);
  }

  public void ReverseHalfSpeed() {
    intakeMotor.set(-.5);
  }

  public void Stop() {
    intakeMotor.set(0);
  }

}
