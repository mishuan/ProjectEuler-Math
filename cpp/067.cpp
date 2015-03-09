#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// ifstream to stream file
	ifstream ifs("triangle.txt");
	int biggest_sum = 0;
	int ** dimension = new int*[100];
	regex r(" ");
	string s;
	string temp;
	int m = 0;
	int n = 0;

	for (int i = 0; i < 100; i++)
	{
		dimension[i] = new int[i+1];
	}
	//gets line of ifs, puts it in s
	while (getline(ifs, s))
	{
		for (sregex_token_iterator it = sregex_token_iterator(s.begin(), s.end(), r, -1); it != sregex_token_iterator(); ++it)
		{
			temp = *it;
			dimension[m][n] = atoi(temp.c_str());
			n++;
		}
		n = 0;
		m++;
	}

	for (int i = 99; i > 0; i--)
	{
		for (int j = 0; j < i; j++)
		{
			dimension[i-1][j] += max(dimension[i][j], dimension[i][j+1]);
		}
	}

	cout << dimension[0][0] << endl;
	return 0;
}