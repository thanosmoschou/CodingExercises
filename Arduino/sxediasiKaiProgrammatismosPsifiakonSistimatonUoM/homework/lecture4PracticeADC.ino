// C++ code
//
void setup()
{
  pinMode(4, OUTPUT);
}

void loop()
{
  // 3V 
  if (analogRead(A0) > 613) {
    digitalWrite(4, HIGH);
  } else {
    digitalWrite(4, LOW);
  }
}