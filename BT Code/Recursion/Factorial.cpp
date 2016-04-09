#include <iostream>
#include <stack>
using namespace std;
int func(int n){
	if(n == 1) return 1;
	else return n*func(n-1);
}
long int Fac(int n){
	stack<int> mystack;
	mystack.push(n);
	int result = 1;
	while (!mystack.empty()){
		int i = mystack.top();
		mystack.pop();
		result *= i;
		if ( i > 1 ) mystack.push(i-1);
	}
	return result;
}
int main(){
	cout << " Calculate Factorial ";
	// cout << Fac(16);
	cout << func(16);
}
