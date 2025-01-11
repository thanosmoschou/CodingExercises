/*
Author: Thanos Moschou
Description: Lecture 12 Use Case, Old exam

Components:
1 Uno R3
4 Red Leds
4 Resistors 220 Ohm
1 TMP36 temperature sensor
Jumper Wires
*/

int pins[] = {12, 8, 5, 2};
int temperatures[] = {0, 14, 29, 44, 50};
int length = 4;

int tmp36 = A0;

void setup()
{
  for (int i = 0; i < length; i++) {
    pinMode(pins[i], OUTPUT);
  }
  
  pinMode(tmp36, INPUT);
  
  for (int i = 0; i < length; i++) {
    digitalWrite(pins[i], LOW);
  }
}

void blink() {
  for (int i = 0; i < length; i++) {
    digitalWrite(pins[i], HIGH);
  }
  
  delay(500);
  
  for (int i = 0; i < length; i++) {
    digitalWrite(pins[i], LOW);
  }
  
  delay(500);
}

void loop()
{
  int d = analogRead(tmp36);
  float temperature = 0.49 * d - 50;
  
  if (temperature > temperatures[length]) {
    blink();
  } else {
    for (int i = 0; i < length; i++) {
      if (temperature >= temperatures[i]) {
        digitalWrite(pins[i], HIGH);
      } else {
        digitalWrite(pins[i], LOW);
      }
    }
  }
}