#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

bool is_palindrome( int number )
{
	string palindrome = to_string(number);

	for ( int i = 0; i < palindrome.length()/2; i++)
	{
		if( palindrome[i] != palindrome[palindrome.length() - 1 - i] )
		{
			return false;
		}
	}
	return true;
}
// the better way to implement this is to realize all palindrome numbers require one factor
// to be a factor by 11.  Use this to our advantage for incrementing and decrementing, and 
// the run time will be cut down dratistically 
int _tmain(int argc, _TCHAR* argv[])
{
	int palindrome = 0;
	int divisor1 = 999;
	int divisor2 = 999;
	int largest_palindrome = 0;

	while (divisor1 > 100)
	{
		for ( int i = divisor1; divisor1 > i - 100; divisor1--)
		{
			for ( int i = divisor2; divisor2 > i - 100; divisor2--)
			{
				palindrome = divisor1 * divisor2;
				if ( is_palindrome( palindrome )  && palindrome > largest_palindrome )
				{
					largest_palindrome = palindrome;
				}
			}
			divisor2 += 100;
		}
		divisor1 -= 100;
	}
	cout << largest_palindrome;
	return 0;
}

