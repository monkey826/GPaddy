#include <iostream>
using namespace std;
int X(int n);
int Y(int n);
int Y(int n){
	if ( n==1) return 4;
	return  X(n-1) - 5;
}
int X(int n){
	if ( n == 1) return 2;
	return  Y(n-1) + 3;
}

int cal(int n){
	int a = 2;
	int b = 4;
	int x,y;
	for ( int i = 2 ; i <= n ; i ++ ){
		x = b + 3;
		y = a + -5;
		a = x;
		b = y;
	}
	cout << x<<endl;
	cout << y;
}
main(){
	cal(2);
	cout<<X(2);
	cout<<Y(2);
}
