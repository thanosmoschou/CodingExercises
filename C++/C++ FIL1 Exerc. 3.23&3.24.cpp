#include <iostream>
using namespace std;


int main()
{
	int max=-1,min=10000000,num;

	for (int i=1; i<=5; i++)
	{
		cout << "Insert a number: "<< endl;
		cin >> num;

		if (num>max)
		{
			max=num;
		}

		if (num<min)
		{
			min=num;
		}

	}

	cout << "Largest number in the group: "<< max<< endl;
	cout << "Smallest number in the group: "<< min<< endl;


	/*--------------------------------------------------------------------------------*/

	int num1;

	cout <<"Insert a number: "<< endl;
	cin >> num1;

	if (num1%2==0)
	{
		cout << "Even.."<<endl;
	}
    else
	{
		cout << "Odd.."<< endl;
	}
	return 0;
}
