#include <stdio.h>
int main(void)
{
	int i, num;
	double fact;

	printf("Enter number within [0, 170]: ");
	scanf("%d", &num);

	if (num >= 0 && num <= 170)
	{
		fact = 1; /* Θέτουμε αρχική τιμή ίση με το ένα, για να γίνει σωστά ο υπολογισμός του παραγοντικού. */
		for (i = 1; i <= num; i++)
			fact = fact*i;
		/* Σε περίπτωση που ο χρήστης εισάγει την τιμή 0,  τότε ο for βρόχος δεν εκτελείται, γιατί η συνθήκη (i <= num) είναι ψευδής, αφού i = 1 και num = 0. Επομένως, η τιμή που θα εμφανιστεί θα είναι η αρχική τιμή της fact, δηλαδή 1, η οποία είναι και σωστή αφού 0! = 1. */
		printf("Factorial of %d is %e\n", num, fact);
	}
	else
		printf("Error: Number should be within [0, 170]\n");
	return 0;
}