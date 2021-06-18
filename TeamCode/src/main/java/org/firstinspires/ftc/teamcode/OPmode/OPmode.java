package org.firstinspires.ftc.teamcode.OPmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.sistem.wobbleArm;

@TeleOp(name = "driver", group = "teleop")

public class OPmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        wobbleArm wobble = new wobbleArm(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.dpad_up){
                wobble.moveArm(0.1);
            }else if(gamepad1.dpad_down){
                wobble.moveArm(-0.1);
            }else {
                wobble.moveArm(0);
            }
            if (gamepad1.b){
                wobble.grabWobble(false);
            }else if (gamepad1.y){
                wobble.grabWobble(true);
            }
        }
    }
}
