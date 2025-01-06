/*
Author: Thanos Moschou
Description: Ch4 ex3

Components:
4 AA Batteries 1.5V
1 5V Regulator LM7805
1 Photoresistor
1 Resistor 10K Ohm
1 ATTiny85
1 Micro Servo
Jumper Wires
*/

int photoPin = A0; // PB5 is digital pin 5 and A0 for analog input
int servoPin = 0;

void setup()
{
  pinMode(servoPin, OUTPUT);
  pinMode(photoPin, INPUT);
}

void loop()
{
  int d = analogRead(photoPin);
  int mapped = map(d, 0, 1023, 0, 255); // Map d values from range 0-1023 of ADC to range 0-255 for PWM
  
  analogWrite(servoPin, mapped);
  delay(500);
}