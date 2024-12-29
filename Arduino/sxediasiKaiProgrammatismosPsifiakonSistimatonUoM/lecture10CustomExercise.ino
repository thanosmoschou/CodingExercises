/*
Author: Thanos Moschou

Description: A circuit that changes
the LED color depending on temperature.
For temperatures under 0 degrees Celcius
the led color is blue, for temperatures
under 30 degrees Celcius the led is green, 
otherwise it is red.

Components:

1 ATTiny
1 breadboard
1 5V regulator LM7805
1 Temperature Sensor TMP36
1 9V battery
1 RGB Led
3 Resistors 220 Ohm
Jumper wires
*/

int temperPin = A0; // PB5 is also A0
int redPin = 2; // PB2
int bluePin = 1; // PB1
int greenPin = 3; // PB3

void setup()
{
  pinMode(redPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  
  digitalWrite(redPin, LOW);
  digitalWrite(bluePin, LOW);
  digitalWrite(greenPin, LOW);
}

void loop()
{
  int d = analogRead(temperPin);
  float temperature = 0.49 * d - 50;
  
  if (temperature < 0) {
    digitalWrite(bluePin, HIGH);
    digitalWrite(redPin, LOW);
    digitalWrite(greenPin, LOW);
  } else if (temperature < 30) {
    digitalWrite(greenPin, HIGH);
    digitalWrite(bluePin, LOW);
    digitalWrite(redPin, LOW);
  } else {
    digitalWrite(redPin, HIGH);
    digitalWrite(bluePin, LOW);
    digitalWrite(greenPin, LOW);
  }
  
  delay(500);
}