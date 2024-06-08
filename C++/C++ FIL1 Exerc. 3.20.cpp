#include <iostream>
using namespace std;

int main()
{
	int radius,pi=3.14159;

	cout << "Insert the value of radius: "<< endl;
	cin >> radius;

	cout << "The diameter is "<< 2*radius <<endl;
	cout << "The circumference is "<< 2*pi*radius <<endl;
	cout << "The area is "<< pi*(radius*radius) <<endl;

	return 0;
}
