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
public class Cameras{
    public static int HatchCamera = Robot.getPreferences().getInt("HatchCamera-USB", 0);
    public static int DriveCamera = Robot.getPreferences().getInt("DriveCamera-USB", 1);
}
