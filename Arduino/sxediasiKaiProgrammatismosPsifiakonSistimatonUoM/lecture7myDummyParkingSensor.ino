/*
Author: Thanos Moschou
Description: Dummy Parking Sensor

Components:
1 Uno R3
1 Breadboard
1 Piezo
1 Resistor 100 Ohm
1 Distance Sensor HC-SR04
Jumper Wires
*/

#define ALARM_NOTE_AWAY 400
#define ALARM_NOTE_NEAR 200

const int piezoPin = 2;
const int trigPin = 3;
const int echoPin = 4;

long duration;
float distance;
const int alarmDistance = 50;

void setup()
{
  pinMode(echoPin, INPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(piezoPin, OUTPUT);
  
  digitalWrite(trigPin, LOW); // Make sure distance sensor is off.
  
  Serial.begin(9600);
}

void loop()
{
  // Enable distance sensor
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW); // Now echo pin is enabled. Let's see how long it will be enabled and calculate the distance based on the duration it is enabled.
  
  // Calculate distance
  duration = pulseIn(echoPin, HIGH); 
  distance = duration * 0.034 / 2;
  
  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");
  
  if (distance < alarmDistance) {
    tone(piezoPin, ALARM_NOTE_NEAR);
    delay(100);
    noTone(piezoPin);
    delay(100);
  } else {
    tone(piezoPin, ALARM_NOTE_AWAY);
    delay(100);
    noTone(piezoPin);
    delay(100);
  }
     
  delay(100);
    
}