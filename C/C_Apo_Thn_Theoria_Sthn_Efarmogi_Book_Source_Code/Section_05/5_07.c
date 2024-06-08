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
	else if(bmi <= 25) /* ���� �� �� ����������� if �������� ��� ����� ����� �� 20, ���� � ������� ����� ��������� �� else if(bmi >= 20 && bmi <= 25). */
		printf("Normal weight\n");
	else if(bmi <= 30)
		printf("Overweight\n");
	else if(bmi <= 40)
		printf("Obese\n");
	else 
		printf("Serious obesity\n");

	printf("According to your height the bounds of normal weight are [%.2f-%.2f]\n", 20*height*height, 25*height*height); /* ������� �� ��� ������ �� ���� ��� BMI ��� ����������� ����� ����� 20 ��� 25 ����������. */
	return 0;
}