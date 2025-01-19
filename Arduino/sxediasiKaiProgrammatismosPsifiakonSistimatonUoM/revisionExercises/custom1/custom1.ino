/*
Author: Thanos Moschou
Description: Custom 1

Sliderswitch that enables a led
Potentiometer that changes the light levels for a led.
Pushbutton that makes a servo rotate 90 degrees.

Components:
1 Uno R3
1 Microservo
3 Resistors 220 Ohm
1 Pushbutton
2 LEDS
1 Potentiometer
1 Slider switch
Jumper wires
*/

#include <Servo.h>

int pushbtn = 2;
int servoPin = 3;

Servo myServo;

void setup()
{
  pinMode(pushbtn, INPUT);
  pinMode(servoPin, OUTPUT);
  
  digitalWrite(servoPin, LOW);
  
  myServo.attach(servoPin);
}

void loop()
{
  if (digitalRead(pushbtn) == HIGH) {
    myServo.write(90);
  } else {
    myServo.write(0);
  }
  
  delay(500);
}