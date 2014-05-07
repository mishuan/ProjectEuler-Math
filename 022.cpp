#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;
int _tmain(int argc, _TCHAR* argv[])
{
	// define variables
	ifstream ifs("names.txt");
	int sum = 0;
	int index = 0;
	string names[5163];
	regex r(",");
	string temp;
	string s;

	//read file
	getline(ifs, s);
	sregex_token_iterator it = sregex_token_iterator(s.begin(), s.end(), r, -1);
	for (int i = 0; i < 5163; i++)
	{
		temp = *it;
		names[i] = temp;
		++it;
	}

	//sort names
	sort(begin(names),end(names));

	//calculate
	int word_sum = 0;
	for(int i = 0; i < 5163; i++)
	{
		for(int j = 0; j < names[i].length(); j++)
		{
			word_sum += static_cast<int>(names[i][j]) - 64;
		}
		sum += word_sum*(i+1);
		word_sum = 0;
	}
	cout << sum << endl;	
	return 0;
}
