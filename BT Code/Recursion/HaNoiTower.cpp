#include <iostream>
#include <stack>
using namespace std;
struct stack{
	int n;
	char a,b,c;
};
void push(stack<stack> s, int n , char a , char b, char c){
	stack sta;
	sta.n = n;
	sta.a=a;
	sta.b=b;
	sta.c=c;
	s.push(sta);

}
long HaNoiTower(int n){
	char a = 'A';
	char b = 'B';
	char c = 'C';
	stack s; 
	int m ;
	push(s,n,a,b,c);
	while(!s.empty()){
		pop(s,n,a,b,c);	
		if ( n==1 )
			cout<< " Move "<<a<<" To "<<c<<"\n";
		else{
			m = n - 1;
			push(s,m,a,c,b);
			push(s,1,a,b,c);
			push(s,m,c,b,a);
		}
	}
}
main(){
	HaNoiTower(3);
}