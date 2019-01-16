/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

public class Drivetrain extends Subsystem { 

  Spark leftFrontMotor = null;
  Spark leftBackMotor = null;
  Spark rightFrontMotor = null;
  Spark rightBackMotor = null;

  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    // Motors
    leftFrontMotor = new Spark(RobotMap.DRIVETRAIN_LEFT_FRONT_MOTOR);
    leftBackMotor = new Spark(RobotMap.DRIVETRAIN_LEFT_BACK_MOTOR);
    rightFrontMotor = new Spark(RobotMap.DRIVETRAIN_RIGHT_FRONT_MOTOR);
    rightBackMotor = new Spark(RobotMap.DRIVETRAIN_RIGHT_BACK_MOTOR);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
    
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void initDefaultCommand() {
  	setDefaultCommand(new DriveArcade());
  }
}
