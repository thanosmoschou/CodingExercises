/*
Author: Thanos Moschou
Description: Custom3 for exams preparation

Components:
1 Uno R3
1 RGB Led
2 Resistors 220 Ohm
1 HC-SR04 Distance Sensor
Jumper Wires
*/

int redPin = 3;
int greenPin = 2;
int trigPin = 4;
int echoPin = 5;

float DANGER_ZONE = 50.0;

void setup()
{
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  digitalWrite(trigPin, LOW); // Make sure sensor is off

}

void red_blink() 
{  
  digitalWrite(redPin, HIGH);
  delay(100);
  digitalWrite(redPin, LOW);
  delay(100);
}

void loop()
{  
  // Enable trigger in the sensor
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  
  // Calculate the time that echo pin was enabled and then calculate the distance
  int dur = pulseIn(echoPin, HIGH);
  float distance = 0.01723 * dur;
  
  if (distance <= DANGER_ZONE) {
    digitalWrite(greenPin, LOW);
    red_blink();
  } else {
    digitalWrite(greenPin, HIGH);
    digitalWrite(redPin, LOW);
  }  
}