#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

//a = m^2 - n^2 , b = 2*m*n , c = m^2 + n^2
// ^ use this property to further optimize
int _tmain(int argc, _TCHAR* argv[])
{
	int product = 0;
	int k = 0;
	int a = 0;
	int b = 0;

	for (int i = 500; i >= 1; i--)
	{
		for (int j = 1; j < i/2; j++)
		{
			k = 1000 - j - i;

			if ( k*k + j*j == i*i )
			{
				product = k*j*i;
				break;
			}
		}
	}
	cout << product;
	return 0;
}

