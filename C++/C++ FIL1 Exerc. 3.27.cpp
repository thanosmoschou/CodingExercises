#include <iostream>
using namespace std;


int main()
{
	char ch;

	cout << "Insert a character: "<<endl;
	cin >> ch;

	cout << static_cast < int > (ch);  /*Η εντολή αυτή δείχνει τον χαρακτήρα που πληκτρολογήθηκε ως έναν ακέραιο
	του πίνακα ASCII*/



	return 0;
}
