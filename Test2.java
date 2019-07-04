/*
密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串

输入描述:
一组或多组长度超过2的子符串。每组占一行
输出描述:
如果符合要求输出：OK，否则输出NG

示例1
输入
021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000
输出
OK
NG
NG
OK
*/
package written_test0704;

import java.util.Scanner;
//密码验证合格程序
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String str = judge(s);
            String str2 = compare(s);
            if(str.equals(str2)){
                System.out.println(str);

            } else{
                System.out.println("NG");
            }
        }
    }
    public static String judge(String s){
        int len = s.length();
        if(len <=8 ){
            return "NG";
        }
        int[] nums = new int[4];
        for(int i = 0;i<len;i++){
            if(s.charAt(i)>47 && s.charAt(i)<=57){
                nums[0]++;
            }else if(s.charAt(i)>=65 && s.charAt(i)<=90 ){
                nums[1]++;
            }else if(s.charAt(i)>=97 && s.charAt(i)<=122 ){
                nums[2]++;
            }else{
                nums[3] ++;

            }
        }
        int count = 0;
        for(int i:nums){
            if(i >0){
                count ++;
            }
        }
        if(count <3){
            return "NG";
        }
        return "OK";
    }
    public static String compare(String s){
        int len = s.length();
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                int count = 0;
                int a = i;
                int b = j;
                while(a<len && b<len &&(s.charAt(a) == s.charAt(b))){
                    count ++;
                    a++;
                    b++;
                }
                if(count >2){
                    return "NG";
                }
            }
        }
        return "OK";
    }
}
