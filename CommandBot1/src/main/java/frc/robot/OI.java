/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.properties.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public static final Joystick DriverStick = new Joystick(RobotMap.DriveJoystick);
  public static final Joystick OperatorStick = new Joystick(RobotMap.OperateJoyStick);

  Button ButtonY = new JoystickButton(OperatorStick, 0);
  Button ButtonX = new JoystickButton(OperatorStick, 1);
  Button ButtonA = new JoystickButton(OperatorStick, 2);
  Button ButtonB = new JoystickButton(OperatorStick, 3);
  Button ButtonL1 = new JoystickButton(OperatorStick, 4);
  Button ButtonR1 = new JoystickButton(OperatorStick, 5);
  Button ButtonL2 = new JoystickButton(OperatorStick, 6);
  Button ButtonR2 = new JoystickButton(OperatorStick, 7);
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // ButtonX.whenPressed(new StoreHatch());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public OI() {
    ButtonX.whenPressed(new StoreHatch());
    ButtonY.whenPressed(new PickupHatch());
    ButtonA.whenPressed(new DeliverHatch());
    ButtonB.whenPressed(new LowerHatchArm());
    ButtonL1.whenPressed(new UnjamCargo());
    ButtonR1.whenPressed(new PlaceCargoInRocket());
    ButtonL2.whenPressed(new PlaceCargoInShip());
    ButtonR2.whenPressed(new PickupCargo());
  }
}
