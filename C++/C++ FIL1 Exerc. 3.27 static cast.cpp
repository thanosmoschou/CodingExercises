#include <iostream>
using namespace std;


int main()
{
	char ch;

	cout << "Insert a character: "<<endl;
	cin >> ch;

	cout << static_cast < int > (ch);  /*� ������ ���� ������� ��� ��������� ��� ��������������� �� ���� �������
	��� ������ ASCII*/



	return 0;
}
