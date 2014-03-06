#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	int sum = 5;
	int is_prime_num = 0;
	bool is_prime;
	int counter = 1;
	int * prime_array = new int[1000000];
	int array_size = 2;
	prime_array[0] = 2;
	prime_array[1] = 3;

	while(counter*6 < 2000000)
	{
		is_prime = true;
		is_prime_num = counter*6 + 1;

		for (int i = 1; i < array_size; i++)
		{
			if (sqrt(is_prime_num) < prime_array[i])
			{
				break;
			}
			if(is_prime_num % prime_array[i] == 0)
			{
				is_prime = false;
				break;
			}
		}
		if (is_prime)
		{
			prime_array[array_size] = is_prime_num;
			array_size++;
			sum += is_prime_num;
		}

		is_prime = true;
		is_prime_num = counter*6 - 1;

		for (int i = 1; i < array_size; i++)
		{
			if (sqrt(is_prime_num) < prime_array[i])
			{
				break;
			}
			if(is_prime_num % prime_array[i] == 0)
			{
				is_prime = false;
				break;
			}
		}
		if (is_prime)
		{
			prime_array[array_size] = is_prime_num;
			array_size++;
			sum += is_prime_num;
		}

		counter ++;
		cout << array_size << endl;
	}
	
	cout << sum;
	return 0;
}

