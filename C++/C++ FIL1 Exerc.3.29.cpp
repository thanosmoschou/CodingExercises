#include <iostream>
using namespace std;

int main()
{

	cout << "integer   square   cube" << endl;

	for (int i=0; i<=10; i++)
	{
	   if (i==10)
	   {
			cout << i << "        " << i*i << "      " << i*i*i << endl;
	   }
       else if (i>=4)
	   {
			cout << i << "         " << i*i << "       " << i*i*i << endl;
	   }
	   else
	   {
			cout << i << "         " << i*i << "        " << i*i*i << endl;
	   }

	}


	return 0;
}
