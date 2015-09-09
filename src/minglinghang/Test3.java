package minglinghang;

import java.util.Scanner;

public class Test3 {
 public static void main(String[] args) { 
  Scanner fin =new Scanner(System.in);
  String str=fin.next();
  int num= fin.nextInt();
  
  int [] strs=new int [26];//-a
  String [] strs2=new String [26];//-w 10
  
  String [] result = new String [num];
  String s ; //输入每行命令
  fin.nextLine();
  
  //保存第一行
  for(int i=0;i<str.length();i++){
   strs2[str.charAt(i)-'a']=""+str.charAt(i);
   if(i==str.length()-1){
    strs[str.charAt(i)-'a']=1;
    break;
   }
   if(str.charAt(i+1)!=':'){
    strs[str.charAt(i)-'a']=1;
   }else{
    strs[str.charAt(i)-'a']=2;
    i++;
   }
  }
  for(int i=0;i<num;i++){
   
    s=fin.nextLine();
    s=s.trim();
   int  [] number=new int[26];
   
   String[] ss=s.split(" ");
   
   //判断保存
   for(int k=1;k<ss.length;k++){
    if(strs[ss[k].charAt(1)-'a']==2){
     number[ss[k].charAt(1)-'a']=Integer.parseInt(ss[k+1]);
     k++;
    }else if(strs[ss[k].charAt(1)-'a']==1){
     number[ss[k].charAt(1)-'a']=-1;
    }else{
     number[ss[k].charAt(1)-'a']=0;
     break;
    }
   }
   
   //输出
   result[i]="Case "+(i+1)+": ";
   for(int k=0;k<26;k++){
    if(number[k]==-1){
     result[i]+="-"+strs2[k]+" ";
    }else if(number[k]>0) {
     result[i]+="-"+strs2[k]+" "+number[k]+" ";
    }else{
     continue;
    }
   }
  }
  for(int i=0;i<num;i++){
   System.out.println(result[i]);
  }
 }
}