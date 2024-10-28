// C++ code
//
void setup()
{
  Serial.begin(9600); // Start serial communication at 9600 baud rate
  Serial.println("Starting program..."); // Print an initial message
  pinMode(2, INPUT);
  pinMode(3, OUTPUT);
}

void loop()
{ 
  /*
  if (digitalRead(2) == HIGH) {
    digitalWrite(3, HIGH);
  } else {
    digitalWrite(3, LOW);
  }
  */
  
  // loop() is endless. It starts again 
  // when it reaches its end.
  // If we do not enter the if
  // then pin 2 will have its previous value
  // continuously.
  // analogWrite keeps sending the same value
  // until I change it.
  if (digitalRead(2) == HIGH) {
    for (int i = 0; i < 10; i++) {
      Serial.println(i);
      analogWrite(3, i*20);
      delay(20);
    }
    analogWrite(3, 0);
  }
}