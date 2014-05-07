#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

// this one was straight forward and simple, just map out the prime factors
// and multiply in the missing ones
int _tmain(int argc, _TCHAR* argv[])
{
	int magic_number = 2520;

	magic_number = magic_number * 11 * 13 * 2 * 17 * 19;

	cout << magic_number;
	return 0;
}

