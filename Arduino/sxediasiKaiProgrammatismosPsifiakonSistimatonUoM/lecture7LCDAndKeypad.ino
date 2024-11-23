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

void updateScreen() {
  int d = analogRead(inputAnalogPin);
  String key;
    
  // Prevent continuous empty message. Maybe solve this with interrupts.
  if (prevValue == d || d == 0) {
    return;
  } else {
    prevValue = d;
  }
  
  switch (d) {
    case 1023:
    	key = "1";
    	break;
    case 511:
    	key = "2";
    	break;
    case 341:
    	key = "3";
    	break;
    case 256:
    	key = "A";
    	break;
    case 205:
    	key = "4";
    	break;
    case 170:
    	key = "5";
    	break;
    case 146:
    	key = "6";
    	break;
    case 128:
    	key = "B";
    	break;
    case 114:
    	key = "7";
    	break;
    case 102:
    	key = "8";
    	break;
    case 93:
    	key = "9";
    	break;
    case 85:
    	key = "C";
    	break;
    case 79:
    	key = "*";
    	break;
    case 73:
    	key = "0";
    	break;
    case 68:
    	key = "#";
    	break;
    case 64:
    	key = "D";
    	break;
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