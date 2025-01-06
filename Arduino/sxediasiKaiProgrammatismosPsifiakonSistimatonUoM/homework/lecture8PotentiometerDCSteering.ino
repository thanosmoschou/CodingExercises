/*
Author: Thanos Moschou
Description: Chapter4, exercise 7

Components:
1 Uno R3
1 Breadboard
2 DC Motors
1 Potentiometer
Jumper Wires
*/

int analogPin = A0;
int dc1Pin = 6;
int dc2Pin = 3;

void setup()
{
  pinMode(analogPin, INPUT);
  pinMode(dc1Pin, OUTPUT);
  pinMode(dc2Pin, OUTPUT);
  
  Serial.begin(9600);
}

void loop()
{
  int value;
  float percentage1, percentage2; // For printing purposes only
  int valueForDC1, valueForDC2;
  
  value = analogRead(analogPin);
  
  percentage1 = value / 1023.0;
  percentage2 = 1 - (value / 1023.0);
  
  // Map 0-1023 values to range 0-255 for analog output
  valueForDC1 = map(value, 0, 1023, 0, 255);
  valueForDC2 = map(1023 - value, 0, 1023, 0, 255);
  
  analogWrite(dc1Pin, valueForDC1);
  analogWrite(dc2Pin, valueForDC2);
  
  Serial.print("Potentiometer analog value: ");
  Serial.println(value);
  
  Serial.print("DC1 Percentage: ");
  Serial.println(percentage1);
  
  Serial.print("DC2 Percentage: ");
  Serial.println(percentage2);
  
  Serial.print("Value for dc1: ");
  Serial.println(valueForDC1);
  
  Serial.print("Value for dc2: ");
  Serial.println(valueForDC2);
  
  delay(500);
}