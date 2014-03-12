#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;

int sum_up(int i, int j, int ** array)
{
	if (i == 14)
	{
		return (array[i][j] > array[i][j+1]) ? array[i][j] : array[i][j+1];
	}
	int left = sum_up(i+1, j, array);
	int right = sum_up(i+1, j+1, array);
	return (left > right) ? array[i][j] + left : array[i][j] + right;
}
int _tmain(int argc, _TCHAR* argv[])
{
	// ifstream to stream file
	ifstream ifs("numbers.txt");
	int biggest_sum = 0;
	int ** dimension = new int*[15];
	regex r(" ");
	string s;
	string temp;
	int m = 0;
	int n = 0;

	for (int i = 0; i < 15; i++)
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
			cout << dimension[m][n];
			n++;
		}
		cout << endl;
		n = 0;
		m++;
	}



	cout << sum_up(0, 0, dimension) << endl;
	return 0;
}