#第十行
#给定一个文本文件file.txt，请只打印这个文件中的第十行。
#
#示例:
#假设file.txt 有如下内容：
#Line 1
#Line 2
#Line 3
#Line 4
#Line 5
#Line 6
#Line 7
#Line 8
#Line 9
#Line 10
#
#你的脚本应当显示第十行：
#Line 10

sed -n '10P' file.txt
