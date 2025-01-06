/* Ch4, ex1 solution
Components:
3 Red Leds
3 Resistors 220 Ohm
1 Breadboard
1 5V regulator
1 9V battery
1 ATtiny
Jumper Wires
*/

int outputPins[] = {2, 4, 5};
int arrLen = sizeof(outputPins) / sizeof(outputPins[0]);

void setup()
{
  for (int i = 0; i < arrLen; i++) {
    pinMode(outputPins[i], OUTPUT);
  }

}

void loop()
{
  for (int i = 0; i < arrLen; i++) {
    digitalWrite(outputPins[i], HIGH);
    delay(500);
    digitalWrite(outputPins[i], LOW);
    delay(500);
  }
}