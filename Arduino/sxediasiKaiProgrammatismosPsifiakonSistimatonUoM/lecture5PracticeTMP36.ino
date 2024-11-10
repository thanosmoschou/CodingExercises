/*
Components:
1 Uno R3
1 TMP36 Sensor
Jumper wires
*/

int d;
double temp;

void setup()
{
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop()
{
  d = analogRead(A0);
  temp = 0.49 * d - 50;
  
  Serial.print("Temperature: ");
  Serial.print(temp);
  Serial.println(" Celcius");
  delay(1000);
}