#include "stdafx.h"
#include <string>
#include <iostream>
#include <fstream>
#include <regex>
#include <sstream>

using namespace std;
int sum_of_factors(int number, int primes[])
{
	int n = number;
	int index = 0;
	int square_sum = 0;
	int sum = 1;
	while( primes[index]*primes[index] <= n && n > 1)
	{
		if(n % primes[index] == 0)
		{
			n /= primes[index];
			square_sum = primes[index]*primes[index];
			while (n % primes[index] == 0)
			{
				n /= primes[index];
				square_sum *= primes[index];
			}
			sum *= (square_sum - 1)/(primes[index]-1);
		}
		index++;
	}
	if ( n > 1 )
	{
		sum *= (n + 1);
	}
	return sum - number;
}
int _tmain(int argc, _TCHAR* argv[])
{
	//calculate some primez
	int array_primes [10000];
	array_primes[0] = 2;
	array_primes[1] = 3;
	int number_of_primes = 2;
	int number_under_inspection = 5;
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
	
	//calculate some abundant numberz
	bool abundant_numbers[28124];
	for (int i = 0; i < 28124; i++)
	{
		abundant_numbers[i] = false;
	}
	for (int i = 12; i < 28124; i++)
	{
		if (abundant_numbers[i] == false)
		{
			if (sum_of_factors(i, array_primes) > i)
			{
				int j = i;
				while(j < 28124)
				{
					abundant_numbers[j] = true;
					j *= 2;
				}
			}
		}	
	}
	
	//sum of numbers that are not the sum of 2 abundant numbers
	long long sum = 0;
	for (int i = 0; i < 20162; i++)
	{
		for (int j = 0; j <= i/2; j++)
		{
			if (abundant_numbers[j] && abundant_numbers[i-j])
			{
				sum += i;
				break;
			}
		}
	}
	sum = (20161+1)*20161/2 - sum;
	cout << sum << endl;
	return 0;
}
