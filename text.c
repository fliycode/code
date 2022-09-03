//#define  _CRT_SECURE_NO_WARNINGS 1
//万能头文件
//#include<cstdio>
//#include<iostream>
//#include<cmath>
//using namespace std;
//int m,t,s;
//int main()
//{
//	cin>>m>>t>>s;
//	if(t==0)//特判t=0的情况
//	{
//		cout<<0<<endl;
//		return 0;
//	}
//	if(s%t==0)//如果s是t的整数倍
//		cout<<max(m-s/t,0)<<endl;
//	else//如果不是
//		cout<<max(m-s/t-1,0)<<endl;
//	return 0;//程序结束
//}
//#include <iostream>
//#include <cstdio>
//#include <algorithm>
//#include <cstring>
//using namespace std;
//int x;
//bool a, b;
//int main(){
//	scanf("%d", &x);
//	a = (x%2==0), b = (x > 4 && x <= 12);//a满足性质1，b满足性质2
//	printf("%d %d %d %d", a & b, a | b, (a && !b || b && !a), !a && !b);
//   //按条件输出就好啦QWQ
//}

//#include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <algorithm>
//using namespace std;
//int n;
//int main()
//{
//  scanf("%d",&n);
//  if((n%400==0) || ((n%4==0) && (n%100!=0)))
//  {
//    printf("1\n");
//  }
//  else
//   printf("0\n");
//   return 0;
//}


//#include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <algorithm>
//using namespace std;
//int x;
//int main()
//{
//  scanf("%d",&x);
//  if(x<=1)
//{
// printf("Today, I ate %d apple.\n",x);
//}
//  else
//  printf("Today, I ate %d apples.\n",x);
//  return 0;
//}

//#include <iostream>
//#include <cstdio>
//#include <cstring>
//#include <algorithm>
//using namespace std;
//int n;
//int main()
//{
//  scanf("%d",&n);
//  if((5*n)>>(11+3*n))
//  {
//  printf("luogu\n");
//  }
//  else
//   printf("local\n");
//   return 0;
//}

//#include<bits/stdc++.h>//万能头文件
//using namespace std;
//  double m,h;
//int main()
//{
//  cin>>m>>h;
// double M=m/(h*h);
// if(M<18.5)
// cout<<"Underweight";
// else if(M<24)
// cout<<"Normal";
// else
// cout<<M<<endl<<"Overweight";
// return 0;
//}

//if后数据必须用判断符号链接
//#include <iostream>
//#include <cstdio>
//using namespace std;
//int y,m;
//int main()
//{
//  cin>>y>>m;
//  if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
//  cout<<31<<endl;
//  else if(m==4||m==6||m==9||m==11)
//  cout<<30<<endl;
//  else if((y%400==0) || ((y%4==0) && (y%100!=0)) &&(m==2))
//  cout<<29<<endl;
//  else
//  cout<<28<<endl;
//  return 0;
//}
