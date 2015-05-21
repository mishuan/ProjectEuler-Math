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
	
	//calculate some amicable numberz
	int sum_amicables = 0;
	int divisor1 = 0;
	int divisor2 = 0;
	for (int i = 3; i <= 10000; i++)
	{
		divisor1 = sum_of_factors(i, array_primes);
		if (divisor1 > i && divisor1 < 10000)
		{
			divisor2 = sum_of_factors(divisor1, array_primes);
			if (divisor2 == i)
			{
				sum_amicables += i + divisor1;
			}
		}
	}
	cout << sum_of_factors(284, array_primes) << endl;
	cout << sum_amicables << endl;
	return 0;
}
