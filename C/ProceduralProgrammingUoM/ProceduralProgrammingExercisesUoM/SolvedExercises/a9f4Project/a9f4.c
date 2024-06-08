#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define feet_equal_to_meter 0.3048


//Function declaration
void Promptmessages(void);
double mintohours(double minut);
double feettometers(double feet);
double celsiustofahrenheit(double cels);
double fahrenheittocelsius(double fahr);


int main()
{
	//Variable declaration
	int indication;
	double lepta,feet,celsius,fahrenheit;

	Promptmessages();
	indication=GetInteger();

	while(indication>0 && indication<5)
	{
		switch(indication)
		{
			case 1:
				printf("Dwse lepta:");
				lepta=GetReal();
				printf("Wres:%g\n", mintohours(lepta));
				break;
			case 2:
				printf("Dwse feet:");
				feet=GetReal();
				printf("Metra:%g\n",feettometers(feet));
				break;
			case 3:
				printf("Dwse celsius:");
				celsius=GetReal();
				printf("Fahrenheit:%g\n",celsiustofahrenheit(celsius));
				break;
			case 4:
				printf("Dwse fahrenheit:");
				fahrenheit=GetReal();
				printf("Celsuis:%g\n", fahrenheittocelsius(fahrenheit));
				break;
			case 5:
				break;

		}

		system("pause");
		printf("\n");
		Promptmessages();
		indication=GetInteger();

	}


	return 0;
}

//Functions for computation
void Promptmessages(void)
{
	printf("AVAILABLE OPTIONS:\n");
	printf("1. CONVERT MINUTES TO HOURS\n");
	printf("2. CONVERT FEET TO METERS\n") ;
	printf("3. CONVERT DEGREES CELSIUS TO DEGREES FAHRENHEIT\n");
	printf("4. CONVERT DEGREES FAHRENHEIT TO DEGREES CELSIUS\n");
	printf("5. QUIT\n");
}

double mintohours(double minut)
{
	return minut/60.0;
}

double feettometers(double feet)
{
	return feet*feet_equal_to_meter;
}

double celsiustofahrenheit(double cels)
{
	return (9.0/5.0)*cels+ 32;
}

double fahrenheittocelsius(double fahr)
{
	return (5.0/9.0)*(fahr-32);
}




