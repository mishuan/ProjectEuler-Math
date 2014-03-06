#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;
// implemented using Sieve of Eratosthenes as well as the fact 
// prime numbers are always 6n+1 or 6n-1
// also reduced computational time by acknowledging the largest common factor 
// for any given number can only be sqrt(number)
// could further be improved using Sieve of Atkin
int _tmain(int argc, _TCHAR* argv[])
{
	long long sum = 5;
	int is_prime = 0;
	int counter = 1;
	int * prime_array = new int[1000000];
	bool * array2mil = new bool[2000000];
	int array_size = 2;
	prime_array[0] = 2;
	prime_array[1] = 3;
	for (int i = 0; i < 2000000; i++)
	{
		array2mil[i] = true;
	}
	array2mil[0] = false;
	while(counter < 333334)
	{
		is_prime = counter*6 - 1;
		if (array2mil[is_prime-1])
		{
			for (int i = 1; i < array_size; i++)
			{
				if (sqrt(is_prime) < prime_array[i])
				{
					break;
				}
				if(is_prime % prime_array[i] == 0)
				{
					int j = is_prime;
					while (j < 2000000 )
					{
						array2mil[j-1] = false;
						j += is_prime;
					}
					break;
				}
			}
			if (array2mil[is_prime-1])
			{
				prime_array[array_size] = is_prime;
				array_size++;
				sum += is_prime;
				int j = is_prime;
				while (j < 2000000 )
				{
					array2mil[j-1] = false;
					j += is_prime;
				}
			}
		}

		//duplicate code, can be refactored.  too lazy
		is_prime = counter*6 + 1;
		if (array2mil[is_prime-1])
		{
			for (int i = 1; i < array_size; i++)
			{
				if (sqrt(is_prime) < prime_array[i])
				{
					break;
				}
				if(is_prime % prime_array[i] == 0)
				{
					int j = is_prime;
					while (j < 2000000 )
					{
						array2mil[j-1] = false;
						j += is_prime;
					}
					break;
				}
			}
			if (array2mil[is_prime-1])
			{
				prime_array[array_size] = is_prime;
				array_size++;
				sum += is_prime;
				int j = is_prime;
				while (j < 2000000 )
				{
					array2mil[j-1] = false;
					j += is_prime;
				}
			}
		}
		counter ++;
	}
	cout << array_size << endl;
	cout << sum;
	return 0;
}

