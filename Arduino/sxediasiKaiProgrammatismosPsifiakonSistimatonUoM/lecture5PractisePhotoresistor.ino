// C++ code
//
const int ldrPin = A0;
const int ledPin = 13;

void setup()
{
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(ledPin, OUTPUT);
}

void loop()
{
  int ldrValue = analogRead(ldrPin);
  
  if (ldrValue < 500) {
    digitalWrite(ledPin, HIGH);
  } else {
    digitalWrite(ledPin, LOW);
  }
  
  delay(100);
}