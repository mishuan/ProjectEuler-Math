#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	int sum = 0;

	for (int t = 1; 3*t < 1000; t++)
	{
		if ( 3*t % 5 != 0 )
		{
			sum = sum + 3*t;
		}
	}
	for (int f = 1; 5*f < 1000; f++)
	{
		sum = sum + 5*f;
	}

	cout << sum;
	
	//233168

	return 0;
}

