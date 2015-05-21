#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;
bool isPandigital(long number){
	long digits = 0;
	long counter = 0;
	while (number > 0){
		long temp = digits;
		digits = digits | 1 << (number % 10) - 1;
		if (temp == digits)
			return false;
		counter++;
		number /= 10;
	}
	return digits == (1 << counter) - 1;
}
int concatenate(int a, int b){
	int c = b;
	while(c > 0){
		a *= 10;
		c /= 10;
	}
	return a + b;
}

int _tmain(int argc, _TCHAR* argv[])
{
	int sum = 0;
	bool * product_exist = new bool[10000];
	memset(product_exist, 0, sizeof(bool)*10000);
	for(int i = 2; i < 100; i++)
	{
		int start = (i > 9) ? 123 : 1234;
		int end = 10000/i;
		for(int k = start; k < end; k++){
			int product = k*i;
			int combined_number = concatenate(concatenate(i, k), product);
			if(isPandigital(combined_number) 
				&& combined_number > 100000000
				&& !product_exist[product]){
				sum += product;
				product_exist[product]=true;
			}
		}
	}
	cout << sum << endl;
	return 0;
}

