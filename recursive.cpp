#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;
//adds up numbers from index first to index last in array x recursively
int addup(int first, int last, int x[])
{
	if (first == last)
	{
		return x[first];
	}
	else if (first + 1 == last)
	{
		return x[first] + x[last];
	}
	else
	{
		return addup(first, first+1, x) + addup(first+2, last, x);
	}
}
/*----------------------------------------------------------*/
//finds nth term in a fibonacci sequence
int fibonacci(int n)
{
	if (n == 1 || n == 2)
	{
		return 1;
	}
	return fibonacci(n-1) + fibonacci(n-2);
}
//sum up to the nth term of a fibonacci sequence using written fibonacci sequence
int sum_fibonacci(int n)
{
	if (n == 1 || n == 2)
	{
		return n;
	}
	return 2*(sum_fibonacci(fibonacci(n-2)) + sum_fibonacci(fibonacci(n-1)));
}
/*----------------------------------------------------------*/
// the above code is inefficient, the below is revised version to calculate fibonacci requence
// this calculates the sequence in a forward order.
int fib_recursive(int a, int b, int n)
{
	if ( n == 1)
		return a;
	if ( n == 2)
		return b;
	return fib_recursive(b, a+b, n-1);
}
int fib(int n)
{
	return fib_recursive(1, 1, n);
}
//s[n] = f[n+2] - 1
//s[n+2] = s[n+1] + f[n+2]
//s[n+2] = s[n+1] + s[n] + 1
//using our already written fib function, we can calculate sum like below
int fib_sum(int n)
{
	return fib(n+2) - 1;
}
/*----------------------------------------------------------*/
int _tmain(int argc, _TCHAR* argv[])
{
	int int_array [] = {1, 3, 4, 5, 2, 7, 6, 9, 3};
	cout << addup(2, 7, int_array) << endl;
	cout << fibonacci(5) << endl;
	cout << sum_fibonacci(5) << endl;
	cout << fib(5) << endl;
	cout << fib_sum(5) << endl;
	return 0;
}
