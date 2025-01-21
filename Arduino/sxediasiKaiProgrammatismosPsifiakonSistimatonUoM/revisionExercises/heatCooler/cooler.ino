/*
Author: Thanos Moschou
Description: Custom4 for exams preparation

Circuit that depending on temperature spins the
dc motor quicker or slower.

Components:
1 Uno R3
1 RGB Led
2 Resistors 220 Ohm
1 DC Motor
1 TMP36 Temperature Sensor
Jumper wires
*/

int redPin = 3;
int greenPin = 2;
int dcPin = 5;
int tmpPin = A0;

float TEMP_LIMIT = 30.5;

void setup()
{
  pinMode(dcPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(redPin, OUTPUT);
  pinMode(tmpPin, INPUT);
  
  digitalWrite(redPin, LOW);
  digitalWrite(greenPin, LOW);
  
  Serial.begin(9600);
}

void loop()
{
  float temper = 0.49 * analogRead(tmpPin) - 50;
    
  if (temper >= TEMP_LIMIT) {
    digitalWrite(redPin, HIGH);
    digitalWrite(greenPin, LOW);
  } else {
    digitalWrite(greenPin, HIGH);
    digitalWrite(redPin, LOW);
  }
  
  int dcPower = map(temper, -40.0, 125.0, 0, 255);
  analogWrite(dcPin, dcPower);
  
  Serial.print("Temperature: ");
  Serial.print(temper);
  Serial.print(" PWM: ");
  Serial.println(dcPower);
}