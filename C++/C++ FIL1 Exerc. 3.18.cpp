#include <iostream>
using namespace std;

int main()
{
	int num1,num2;

	cout << "Insert number 1: "<<endl;
	cin >> num1;

	cout << "Insert number 2: "<<endl;
	cin >> num2;

	if (num1>num2)
	{
		cout << num1<< " is larger"<<endl;
	}
	else if (num1 <num2)
	{
		cout << num2 << " is larger"<<endl;
	}
	else
	{
		cout << "These numbers are equal."<<endl;
	}

   return 0;
}
