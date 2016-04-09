#include <iostream>
using namespace std;
int func(int n){
	if(n == 1) return 1;
	else return n*func(n-1);
}
int func_reduce_recursion(int n){
	int temp = 1;
	if(n == 1) return 1;
	else{
		while(n>1){
			temp *= n;
			n--;
		}
		return temp;
	}
	
}
int main(){
	cout << func_reduce_recursion(3);
}
