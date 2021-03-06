// C++测试项目.cpp: 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
	string convert(string s, int numRows) {
		//对于一行的z字形变换，直接返回即可
		if (numRows == 1)
			return s;

		char** twoDimension;
		//二维数组有numrows行
		twoDimension = new char*[numRows];
		//二维数组定义列，每列有s.length()的长度
		for (int i = 0; i<numRows; i++)
			twoDimension[i] = new char[int(s.length())];

		//标记每个数组行中已经存进多少个元素
		int* cols;
		cols = new int[numRows];
		for (int i = 0; i < numRows; i++)
		{
			//先初始化为0个元素
			cols[i] = 0;
		}
		//flag作为正序存入或者逆序存入的标志，flag=0是正序存入
		bool flag = false;
		for (int i = 0, j = 0; i<int(s.length()); i++) {
			if (!flag) {
				twoDimension[j][cols[j]] = s[i];
				cols[j]++;
				j++;
				//已经正序存入最大，需要逆序存入了
				if (j == numRows) {
					flag = true;
					j = j - 2;
				}
				//对于2行的z字形特殊要求，只在这一个代码块中重复放到twoDimension[0]和twoDimension[1]中
				if (j == 0) {
					flag = false;
				}
			}
			else {

				twoDimension[j][cols[j]] = s[i];
				cols[j]++;
				j--;
				if (j == 0)
				{
					flag = false;
				}

			}
		}
		//遍历所有的数组，保存到字符串中即可
		string temp = "";
		for (int i = 0; i<numRows; i++) {
			for (int j = 0; j<cols[i]; j++)
				temp += twoDimension[i][j];
		}
		return temp;

	}
};
int main()
{
	Solution s1;
	string temp;
	cout<<s1.convert("ABC",2);
    return 0;
}

