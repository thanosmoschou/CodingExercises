/*
Author: Thanos Moschou
Description: Custom circuit for exams preparation

Just a led that is enabled in the dark

Components:
1 Uno R3
1 Resistor 220 Ohm
1 Resistor 10K Ohm
1 Photoresistor
1 Led
Jumper wires
*/

int ledPin = 2;
int photoPin = A0;

void setup()
{
  pinMode(ledPin, OUTPUT);
  pinMode(photoPin, INPUT);
  
  Serial.begin(9600);
}

void loop()
{
  int d = analogRead(photoPin);
  
  Serial.println(d);
  
  if (d < 800) {
    digitalWrite(ledPin, HIGH);
  } else {
    digitalWrite(ledPin, LOW);
  } 
}