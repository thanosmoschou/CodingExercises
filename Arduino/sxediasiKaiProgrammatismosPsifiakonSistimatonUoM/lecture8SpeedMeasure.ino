/*
Author: Thanos Moschou
Description: This project calculates the distance of an object.

Components:
1 Uno R3 Board
1 Distance Sensor HC-SR04
1 Breadboard
Jumper Wires
*/

const int trigPin = 2;
const int echoPin = 3;
const float timeBetweenMeasurements = 0.5; // In seconds

void setup()
{ 
  Serial.begin(9600);
  
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  // Write LOW and delay for 2 microseconds to make sure the sensor is turned off.
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
}

void loop()
{
  float distance1, distance2;
  float speed;
  float distanceCovered;
  
  distance1 = measureDistance();
	
  delay(500);
  
  distance2 = measureDistance();
  
  // To avoid negative speed
  distanceCovered = abs(distance2 - distance1);
    
  speed = distanceCovered / timeBetweenMeasurements;
  
  Serial.print("Distance covered: ");
  Serial.print(distanceCovered);
  Serial.println(" cm");
  
  Serial.print("Speed: ");
  Serial.print(speed);
  Serial.println(" cm/sec");

  delay(1000);
        
}

void triggerSensor() {
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
}

float measureDistance() {
  long duration;

  triggerSensor();
  duration = pulseIn(echoPin, HIGH);
  
  return duration * 0.034 / 2;
}