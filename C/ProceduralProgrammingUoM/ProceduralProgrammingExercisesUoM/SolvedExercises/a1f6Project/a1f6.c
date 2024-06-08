#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

//Func declaration
void GetTime(long SysSecs, int *hours,int *minutes,int *seconds);

int main()
{
	long SystemSecs;
	int  hour, sec, min;

	//Input
	printf("Enter Device Secs: ");
	SystemSecs= GetLong();


	//Computation
	GetTime(SystemSecs, &hour, &min, &sec);

	//Output
	printf("Time is %d:%d:%d\n", hour,min, sec);

	return 0;
}


//Func definition
void GetTime(long SysSecs, int *hours,int *minutes,int *seconds)
{

	*hours= SysSecs/3600; //Take the seconds and convert them to hours by divide them with 3600 secs cause 1 hour=3600 secs
	//so i can see how many hours are there
	*minutes=(SysSecs%3600)/60; //The rest of the division i will divide it by 60 to find the minutes
	*seconds= (SysSecs%3600)%60; //The rest of the division with 60 are the seconds

}
