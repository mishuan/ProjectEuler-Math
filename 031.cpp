#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	int coin_variety[] = {1, 2, 5, 10, 20, 50, 100, 200};
	int sum = 200;
	int * combinations = new int[201];
	memset(combinations, 0, sizeof(int)*201);
	combinations[0] = 1;
	for(int i = 0; i < 8; i++){
		for(int j = coin_variety[i]; j <201; j++){
			combinations[j] += combinations[j-coin_variety[i]];
		}
	}
		
	cout << combinations[200] << endl;

	return 0;
}

