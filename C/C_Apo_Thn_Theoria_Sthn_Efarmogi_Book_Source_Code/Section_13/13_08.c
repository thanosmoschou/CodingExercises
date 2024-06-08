#include <stdio.h>

struct complex
{
	double re; /* Το πραγματικό μέρος του μιγαδικού αριθμού */
	double im; /* Το φανταστικό μέρος του μιγαδικού αριθμού */
};

struct complex operation(struct complex a1, struct complex a2, char sign);

int main(void)
{
	char sign;
	struct complex z1, z2, z;

	printf("Enter real and imaginary part of the first complex number: ");
	scanf("%lf%lf", &z1.re, &z1.im);
	printf("z1 = %f%+fj\n", z1.re, z1.im);

	printf("Enter real and imaginary part of the second complex number: ");
	scanf("%lf%lf", &z2.re, &z2.im);
	printf("z2 = %f%+fj\n", z2.re, z2.im);

	printf("Enter sign (+, -, *, /): ");
	scanf(" %c", &sign); /* Προσθέτουμε ένα κενό μπροστά από το %c, ώστε να παραλείψουμε τον χαρακτήρα νέας γραμμής που είχε παραμείνει από την προηγούμενη εισαγωγή. */
	if (sign == '+' || sign == '-' || sign == '*' || sign == '/')
	{
		if (sign == '/' && z2.re == 0 && z2.im == 0)
			printf("Division by zero is not allowed\n");
		else
		{
			z = operation(z1, z2, sign);
			printf("z = z1 %c z2 = %f%+fj\n", sign, z.re, z.im);
		}
	}
	else
		printf("Wrong sign\n");
	return 0;
}

struct complex operation(struct complex a1, struct complex a2, char sign)
{
	double div;
	struct complex a;

	switch (sign)
	{
	case '+':
		a.re = a1.re + a2.re;
		a.im = a1.im + a2.im;
		break;

	case '-':
		a.re = a1.re - a2.re;
		a.im = a1.im - a2.im;
		break;

	case '*':
		a.re = (a1.re*a2.re) - (a1.im*a2.im);
		a.im = (a1.im*a2.re) + (a1.re*a2.im);
		break;

	case '/':
		div = (a2.re*a2.re) + (a2.im*a2.im);
		a.re = ((a1.re*a2.re) + (a1.im*a2.im)) / div;
		a.im = ((a1.im*a2.re) - (a1.re*a2.im)) / div;
		break;
	}
	return a;
}