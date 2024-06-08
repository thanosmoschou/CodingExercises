#include <stdio.h>

struct time
{
	int hours;
	int mins;
	int secs;
};

struct time mk_time(int *ptr);

int main(void)
{
	int secs;
	struct time t;

	printf("Enter seconds: ");
	scanf("%d", &secs);

	t = mk_time(&secs);
	printf("\nH:%d M:%d S:%d\n", t.hours, t.mins, t.secs);
	return 0;
}

struct time mk_time(int *ptr)
{
	struct time tmp;

	tmp.hours = *ptr / 3600;
	tmp.mins = (*ptr % 3600) / 60;
	tmp.secs = *ptr % 60;
	return tmp;
}