#include <iostream>
#include <stack>
using namespace std;

long int Fibonacci(int n){
	stack<int> mystack;
	int i = 2;
	mystack.push(1);
	mystack.push(1);
	int result = 1;
	while (!mystack.empty()){
		int a = mystack.top();
		mystack.pop();
		int b = mystack.top();
		mystack.pop();
		result = a + b ;
		i++;
		if( i < n ){
			mystack.push(a);
			mystack.push(result);
		}
		
	}
	return result;
}
int main(){
	cout << " Calculate Factorial ";
	cout << Fibonacci(4);
}
