#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	double sum = 0;
	double current = 0;

	for (int f = 1; current < 4000000; f++)
	{
		sum += current;
		// By using induction, we can find a formula to calculate the nth term in a Fibannaci sequence
		current = 1/sqrt(5) * ( pow(((1+sqrt(5))/2), 3*f) - pow(((1-sqrt(5))/2), 3*f) );
	}
	//4613732.0000000000
	cout << sum;

	return 0;
}

