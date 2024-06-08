#include <iostream>
using namespace std;

int main()
{
	int num,rest;

	cout << "Insert a 5-digit number: " << endl;
	cin >> num;

   rest = num;

	for (int i=10000 ; i>=1; i/=10) // � i>=10 ��� ��  ���� ����� ��� cout << rest; ��� ����� ��� for
	{
		cout << rest /i << "  ";
		rest=rest%i;
	}
	//cout << rest; ���� �� ��� �� ��������� ��� ���� for ��� ���� i>=1 ��� ���� i>=10 ��� �� �������� ��� �� ��������� �����

	return 0;
}
