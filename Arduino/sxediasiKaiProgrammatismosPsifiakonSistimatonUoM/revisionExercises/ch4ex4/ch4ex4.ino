/*
Author: Thanos Moschou
Description: Ch4 ex4 but with uno r3 instead of Attiny

Components:
1 Uno R3
1 RGB Led
3 Resistors 220 Ohm
1 Temperature sensor
Jumper Wires
*/

int rLed = 7;
int bLed = 6;
int gLed = 5;

int tempInput = A0;

void setup()
{
  pinMode(rLed, OUTPUT);
  pinMode(bLed, OUTPUT);
  pinMode(gLed, OUTPUT);
  pinMode(tempInput, INPUT);
  
  digitalWrite(rLed, LOW);
  digitalWrite(bLed, LOW);
  digitalWrite(gLed, LOW);
}

void loop() 
{
  int d = analogRead(tempInput);
  float temp = 0.49 * d - 50;
  
  if (temp < 10) {
    digitalWrite(bLed, HIGH);
    digitalWrite(rLed, LOW);
    digitalWrite(gLed, LOW);
  } else if (temp < 30) {
    digitalWrite(gLed, HIGH);
    digitalWrite(bLed, LOW);
    digitalWrite(rLed, LOW);
  } else {
    digitalWrite(rLed, HIGH);
    digitalWrite(bLed, LOW);
    digitalWrite(gLed, LOW);
  }
  
  while (temp == 0.49 * analogRead(tempInput) - 50) {}
}