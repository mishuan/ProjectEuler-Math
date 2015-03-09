#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;
// simple question, could optimize by using the summation formula
int _tmain(int argc, _TCHAR* argv[])
{
	int sum_squared = pow(100*(100+1)/2, 2);
	int squared_sum = 0;
	for (int i = 1; i <= 100; i++)
	{
		squared_sum += pow(i, 2);
	}
	cout << abs(sum_squared - squared_sum);
	return 0;
}

