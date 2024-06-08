#include <stdio.h>
int main(void)
{
	int sex;
	float height;

	printf("Enter sex (0:man - 1:woman): ");
	scanf("%d", &sex);

	printf("Enter height in meters: ");
	scanf("%f", &height);

	switch(sex)
	{
		case 0:
			if(height < 1.70)
				printf("Result: Short\n");
			else if(height < 1.85) /* �� else ����������� ��� ��� �� height ����� >= 1.7 ��� �� if ������� �� �� height ����� < 1.85. ������, ���� �� else if ������� ��� 1.7 <= height < 1.85. */
				printf("Result: Normal\n");
			else
				printf("Result: Tall\n");
		break;

		case 1:
			if(height < 1.60)
				printf("Result: Short\n");
			else if(height < 1.75)
				printf("Result: Normal\n");
			else
				printf("Result: Tall\n");
		break;

		default:
			printf("Error: Wrong input\n");
		break;
	}
	return 0;
}