#include <stdio.h>

#define f(type, text, a) printf(text); scanf(type, &a); printf(type"\n", a);

int main(void)
{
	char ch;
	int i;
	float fl;

	f("%d", "Enter integer: ", i);
	f("%f", "Enter float: ", fl);
	f(" %c", "Enter character: ", ch); /* ��������� ��� ���� ��� �� �������� � scanf() ����� ����������. */
	return 0;
}