/*
Author: Thanos Moschou
Description: Exams 2023

Components:
1 Uno R3
1 RGB Led
3 Resistors 220 Ohm
1 Pushbutton
2 TMP36 temperature sensors
Jumper wires
*/

int redPin = 3;
int greenPin = 2;
int pushbtn = 4;

int tmp1Pin = A0;
int tmp2Pin = A1;

int LIMIT = 15;

void setup()
{
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(tmp1Pin, INPUT);
  pinMode(tmp2Pin, INPUT);
  pinMode(pushbtn, INPUT);
  
  digitalWrite(redPin, LOW);
  digitalWrite(greenPin, LOW);  
}

void loop()
{
  if (digitalRead(pushbtn) == HIGH) {
    int temp1 = 0.49 * analogRead(tmp1Pin) - 50;
    int temp2 = 0.49 * analogRead(tmp2Pin) - 50;
  
  	if (abs(temp1 - temp2) > LIMIT) {
      digitalWrite(redPin, HIGH);
      digitalWrite(greenPin, LOW);
    } else {
      digitalWrite(greenPin, HIGH);
      digitalWrite(redPin, LOW);
    }  
    
    delay(500); // Normally it needs 5000 ms to simulate 5sec
    digitalWrite(redPin, LOW);
    digitalWrite(greenPin, LOW);
  }
}