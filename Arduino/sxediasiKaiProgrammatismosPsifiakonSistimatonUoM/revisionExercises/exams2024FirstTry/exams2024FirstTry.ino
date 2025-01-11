/*
Author: Thanos Moschou
Description: Exams 2024

Components:
1 Uno R3
1 RGB Led
2 Resistors 220 Ohm
1 Photoresistor
1 Resistor 10K Ohm
2 TMP36 temperature sensors
Jumper wires
*/

int redPin = 10;
int greenPin = 9;
int photoPin = A0;
int tmp1Pin = A1;
int tmp2Pin = A2;

void setup()
{
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(photoPin, INPUT);
  pinMode(tmp1Pin, INPUT);
  pinMode(tmp2Pin, INPUT);
  
  digitalWrite(redPin, LOW);
  digitalWrite(greenPin, LOW);
  
  Serial.begin(9600);
}

void loop()
{
  int light = analogRead(photoPin);
  
  Serial.println(light);
  
  if (light > 500) {
    int t1 = 0.49 * analogRead(tmp1Pin) - 50;
    int t2 = 0.49 * analogRead(tmp2Pin) - 50;
    
    if (abs(t1 - t2) > 15) {
      digitalWrite(redPin, HIGH);
      digitalWrite(greenPin, LOW);
    } else {
      digitalWrite(greenPin, HIGH);
      digitalWrite(redPin, LOW);
    }
  } else {
    digitalWrite(redPin, LOW);
    digitalWrite(greenPin, HIGH);
  }  
}