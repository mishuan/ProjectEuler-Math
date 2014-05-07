#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	long long n = 1000000;
	long long x = 0;
	long long cycles = 0;
	long long biggest_cycle = 0;
	long long biggest_number = 0;
	
	while( n > 0)
	{
		x = n;
		while (x != 1)
		{
			if (x % 2 == 0)
			{
				x = x/2;
			}
			else
			{
				x = 3*x+1;
			}
			cycles++;
		}
		if (cycles > biggest_cycle)
		{
			biggest_cycle = cycles;
			biggest_number = n;
		}
		cycles = 0;
		n--;
	}
	cout << biggest_number << endl;
	cout << biggest_cycle << endl;
	return 0;
}
