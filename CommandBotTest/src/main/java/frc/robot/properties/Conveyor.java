/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Conveyor {
    public static int Motor = Robot.getPreferences().getInt("ConveyorMotor-PWM", 4);;
}
