/*
Author: Thanos Moschou
Description: Ch4 ex1

Components:
1 9V Battery
1 5V Regulator
3 Resistors 220 Ohm
1 ATTiny85
3 Leds
Jumper Wires
*/

int pins[] = {0, 1, 2}; // PB0, PB1, PB2
int length = 3;

void setup()
{
  for (int i = 0; i < length; i++) {
    pinMode(pins[i], OUTPUT);
  }
}

void loop()
{
  for (int i = 0; i < length; i++) {
    digitalWrite(pins[i], HIGH);
    delay(500);
    digitalWrite(pins[i], LOW);
    delay(500);
  }
}