#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;
// this can further be optimized using the fact that all primes past 2 and 3 can be
// written in the form 6n-1 or 6n+1
int _tmain(int argc, _TCHAR* argv[])
{
	int array_primes [10000];
	array_primes[0] = 3;
	int number_of_primes = 0;
	int number_under_inspection = 3;
	int largest_prime;
	bool is_prime;

	while ( number_of_primes < 10000 )
	{
		is_prime = true;
		largest_prime = sqrt(number_under_inspection);
		for (int i = 0; i < number_of_primes; i++ )
		{
			if (largest_prime < array_primes[i])
			{
				break;
			}
			if (number_under_inspection % array_primes[i] == 0)
			{
				is_prime = false;
				break;
			}
		}

		if (is_prime)
		{
			array_primes[number_of_primes] = number_under_inspection;
			number_of_primes++;
		}
		number_under_inspection += 2;
	}
	cout << array_primes[9999];
	return 0;
}

