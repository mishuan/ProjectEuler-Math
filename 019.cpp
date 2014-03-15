#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	int year = 1901;
	int days = 366;
	int sundays = 0;
	while(year < 2001)
	{
		for( int i = 0; i < 12; i++)
		{
			if(days % 7 ==0)
			{
				sundays++;
			}
			if(i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11)
			{
				days += 31;
			}
			else if(i == 1)
			{
				if(year % 4 == 0)
				{
					if(year % 100 == 0 && year % 400 != 0)
					{
						days += 28;
					}
					else
					{
						days += 29;
					}
				}
				else
				{
					days += 28;
				}
			}
			else
			{
				days += 30;
			}
		}
		year++;
	}
	cout << sundays << endl;
	return 0;
}
