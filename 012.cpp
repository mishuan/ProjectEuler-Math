#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	/** code from question 10, using sieve and other optimization techniques
	to generate an array of primes**/
	int is_prime = 0;
	int counter = 1;
	int total_factors = 1;
	int num_of_a_factor = 1;
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
				int j = is_prime;
				while (j < 2000000 )
				{
					array2mil[j-1] = false;
					j += is_prime;
				}
			}
		}
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

	/** utilize primes found above to calculate factors of big_triangle number **/
	int big_triangle = 0;
	int n = 100;
	while (true)
	{
		big_triangle = n*(n+1)/2;
		for (int i = 0; i < array_size; i++)
		{
			if (sqrt(big_triangle) < prime_array[i])
			{
				if (big_triangle != 1)
				{
					total_factors *= 2;
				}
				break;
			}
			while (big_triangle % prime_array[i] == 0)
			{
				num_of_a_factor++;
				big_triangle /= prime_array[i];
			}
			total_factors *= num_of_a_factor;
			num_of_a_factor = 1;
		}
		if (total_factors >= 500)
		{
			big_triangle = n*(n+1)/2;
			break;
		}
		total_factors = 1;
		n++;
	}

	cout << big_triangle << endl;
	return 0;
}
