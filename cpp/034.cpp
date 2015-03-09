#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	int * factorial = new int[10];
	factorial[0] = 1;
	int sum = 0;
	for(int i = 1; i < 10; i++){
		factorial[i] = factorial[i-1]*i;
	}
	for(int i = 3; i < 2600000; i++) {
		int temp = i;
		int digitSum = 0;
		while(temp > 0){
			int digit = temp % 10;
			temp /= 10;
			digitSum += factorial[digit];
		}
		if(digitSum == i)
			sum += i;
	}
	cout << sum << endl;
	return 0;
}

