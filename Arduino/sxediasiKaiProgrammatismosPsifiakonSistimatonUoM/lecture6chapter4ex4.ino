/* Ch4, ex4 solution
Components:
1 RGB Led
2 Resistors 220 Ohm
1 Breadboard
1 5V regulator
1 9V battery
1 ATtiny
1 TMP36 sensor
Jumper Wires
*/


void setup()
{
  pinMode(1, OUTPUT);
  pinMode(5, OUTPUT);
  // Serial.begin(9600);

}

void loop()
{
  int d = analogRead(A1);
  
  /*
  float voltage = d * (5.0 / 1023.0);
  float temperature = voltage * 100;
  
  Serial.print("Current d value: ");
  Serial.print(d);
  Serial.print(" which is: ");
  Serial.print(voltage, 3);
  Serial.print(" volt and: ");
  Serial.print(temperature, 1);
  Serial.println(" Celcius");
  */
  
  if (d > 150) {
    digitalWrite(1, LOW);
    digitalWrite(5, HIGH);
  } else {
    digitalWrite(1, HIGH);
    digitalWrite(5, LOW);
  }
}