#include<stdio.h>
#include<stdlib.h>

//Func decl
void decompose(long num, long *dig, float *avg, long *max);


int main()
{
	long num, digits, max;
	float avg;

	printf("Insert a number:");
	scanf("%ld", &num);

	decompose(num, &digits, &avg, &max);

	printf("Digits: %ld\n", digits);
	printf("Average: %.2f\n", avg);
	printf("Max: %ld\n", max);

	system("PAUSE");
}

void decompose(long num, long *dig, float *avg, long *max)
{
	int ctr=1;
	long temp=num, temp1;

	*avg=0;
	*max=temp%10;
	*avg+=(*max); //if the user inserts 0 from the beginning it is pointless to insert into the while loop
	temp/=10;

	if(temp!=0)
	{
		while(1)
		{
			temp1=temp%10;
			if(temp1>(*max)) *max=temp1;

			*avg+= temp1;

			temp/=10;

			ctr++;

			if(temp==0 && temp%10==0) break;
			/*Let's explain the condition with an example..let's say my num is 100..before the while i take the last 0 i do the max computation,
			the avg,i have the counter at 1 because i took 1 number and now i take the remaining number without the last 0(10)
			i take the last digit from the new number into the while(0)..i do the same calculations..i increase the counter because i took another digit
			and now i take the remaining part of the number(1)...now it's time to check if it is time to break the while..
			i had the last 0 outside..i took a 0 inside at the first repeat and the remaining part is 1...if the temp/10==0 i can say that i have one digit remaining
			AND if the temp%10==0 i can say that the last number is 0 and because of i take the digits from right to left the remaining
			is at the left and if its 0 it doesn't count to the number's value so it's time to leave..if the temp%10!=0 i have a number more to count
			so i take it at the next repeat and the remaining part is 0 so i can leave the loop*/
		}

	}

	if(ctr>1)
	{
		*avg/=(ctr);
		*dig=ctr;
	}
	else
	{
		*dig=1;
	}

}
