/*
Author: Thanos Moschou
Description: Servo Motor that changes its motor angle
depending on environment light.

Components:
1 Uno R3
1 Photoresistor
1 Resistor 1K Ohm
1 Micro Servo
1 Breadboard
Jumper Wires
*/

#include <Servo.h>

Servo myServo;

const int servoPin = 3;
const int lightPin = A0;

void setup()
{
  myServo.attach(servoPin);
  Serial.begin(9600);
}

void loop()
{
  int d = analogRead(lightPin);
  
  Serial.println(d);
  
  if (d > 500) {
    myServo.write(100);
  } else {
    myServo.write(0);
  }
  
  delay(500);
  
}