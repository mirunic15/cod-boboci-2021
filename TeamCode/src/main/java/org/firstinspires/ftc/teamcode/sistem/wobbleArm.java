package org.firstinspires.ftc.teamcode.sistem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class wobbleArm {
    private Servo servo;
    private DcMotorEx dcMotor;

    private final double CLAMPED = 1, UNCLAMPED = 0;

    public wobbleArm(HardwareMap hardwareMap){
        servo = hardwareMap.servo.get("servoBrat");
        dcMotor = hardwareMap.get(DcMotorEx.class, "motorBrat");

        dcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        dcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servo.setPosition(UNCLAMPED);
    }

    public void moveArm(double speed){
        dcMotor.setPower(speed);
    }

    public void grabWobble(boolean clamped){
        if(clamped){
            servo.setPosition(CLAMPED);
        }
        else{
            servo.setPosition(UNCLAMPED);
        }
    }
}