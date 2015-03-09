#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	long divisor = 3;
	long long int number_after_division = 600851475143;
	// run when the divided number is bigger than divisor
	while (divisor < number_after_division)
	{
		// divide the same divisor until it does not work
		while ( number_after_division % divisor == 0 )
		{
			number_after_division /= divisor;
		}
		divisor += 2;
	}
	//6857
	cout << divisor;
	return 0;
}

