/*
Author: Thanos Moschou
Description: LCD screen prints the key that is pressed from the keypad.

Calculate the voltage that comes from each digit by using this type:
1K / (1K + R)
R is the total resistance for each key pressed. 
Then use this V to find analog value. Use
this analog value to print the key.

For example:
For key 1 you do not have any resistance so R=0.
For key 2 you have 1K 
For key 8 you have 9K

Components:
1 Uno R3
1 Breadboard
1 LCD 16x2
5 Resistors 1K Ohm
3 Resistors 4K Ohm
1 Keypad 4x4
Jumper Wires
*/

#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

const int inputAnalogPin = A0;
int prevValue = -1;

int analogValues[] = {1023, 511, 341, 256, 205, 170, 146, 128, 114, 102, 93, 85, 79, 73, 68, 64};
String printValues[] = {"1", "2", "3", "A", "4", "5", "6", "B", "7", "8", "9", "C", "*", "0", "#", "D"};
int arrSize = sizeof(analogValues) / sizeof(analogValues[0]);

void updateScreen() {
  int d = analogRead(inputAnalogPin);
  String key;
    
  // Prevent continuous empty message. Maybe solve this with interrupts.
  if (prevValue == d || d == 0) {
    return;
  } else {
    prevValue = d;
  }
  
  for (int i = 0; i < arrSize; i++) {
    if (d == analogValues[i]) {
      key = printValues[i];
      break;
    }
  }
  
  lcd.setCursor(0, 1);
  lcd.print("Key Pressed: " + key);
  Serial.print("Key Pressed: ");
  Serial.println(key);
}

void setup()
{
  for (int i = 2; i < 12; i++) {
    pinMode(i, OUTPUT);
  }
    
  lcd.begin(16, 2);
  Serial.begin(9600);
}

void loop()
{
    updateScreen();
  	delay(500);
}