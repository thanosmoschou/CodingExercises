#include <stdio.h>
int main(void)
{
	float bmi, height, weight;
	
	printf("Enter height (in meters): ");
	scanf("%f", &height);

	printf("Enter weight (in kgrs): ");
	scanf("%f", &weight);

	bmi = weight/(height*height);
	printf("***** BMI: %.2f\n", bmi);

	if(bmi < 20)
		printf("Under normal weight\n");
	else if(bmi <= 25) /* Αφού με το προηγούμενο if ελέγξαμε τις τιμές μέχρι το 20, αυτή η συνθήκη είναι ισοδύναμη με else if(bmi >= 20 && bmi <= 25). */
		printf("Normal weight\n");
	else if(bmi <= 30)
		printf("Overweight\n");
	else if(bmi <= 40)
		printf("Obese\n");
	else 
		printf("Serious obesity\n");

	printf("According to your height the bounds of normal weight are [%.2f-%.2f]\n", 20*height*height, 25*height*height); /* Σύμφωνα με τον πίνακα τα όρια του BMI για φυσιολογικό βάρος είναι 20 και 25 αντίστοιχα. */
	return 0;
}