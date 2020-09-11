package squareshifttask;

import java.util.*;
public class taskcls {
public static void main(String[] args){
Scanner inputscan=new Scanner(System.in);
System.out.println("Enter input String:");
 String s=inputscan.nextLine();
 s=s.replace("[","");
 s=s.substring(0,s.length()-2);
 String s1[]=s.split("],");
 String my_matrics[][] = new String[s1.length][s1.length];//declaring two dimensional matrix for input
 for(int i=0;i<s1.length;i++)
 {
  s1[i]=s1[i].trim();//ignoring all extra space if the string s1[i] has
  String single_int[]=s1[i].split(", ");//separating integers by ", "
  String double_int[]=single_int[0].split(",");
    for(int j=0;j<double_int.length;j++)
    {
      my_matrics[i][j]=double_int[j];//adding single values
    }
   }
    int dcol[]=new int[s1.length];
	int drow[]=new int[s1.length];
	int arr[][]=new int[s1.length][s1.length];
	for(int i=0;i<my_matrics.length;i++)
	{
	   for(int j=0;j<2;j++)
	   {
	        if(my_matrics[i][j]!=null)
	         arr[i][j]=Integer.parseInt(my_matrics[i][j]);
	        //System.out.println(i+" "+j+" ");
	        System.out.print(arr[i][j]);
	        dcol[i]=arr[i][0];
	        drow[i]=arr[i][1];
	        System.out.println();
	    }
	    System.out.println("");
	 }
	    for(int i=0;i<s1.length;i++)
	    {
	    System.out.print(dcol[i]+" ");
	    System.out.print(drow[i]+" ");
	    }
	    System.out.println();
	    System.out.println("Enter passenger id:");
	    String m=inputscan.nextLine();
	    m=m.replace("[", "");
	    m=m.replace("]", "");
	    String[] input=m.split(",");
	    int[] inparr=new int[input.length];
	    for(int i=0;i<inparr.length;i++)
	    {
	    inparr[i]=Integer.parseInt(input[i]);
	    }
	    List<Integer> firstpriorarr=primeprior(inparr);
	    List<Integer> secondprior=twopower(inparr,firstpriorarr);
	    List<Integer> thirdprior=regular(inparr,secondprior);
	    System.out.println("**************************************************"); 
	    int [] finalarray = new int[thirdprior.size()];
	    int index = 0;
	    for(int val:thirdprior){
	        finalarray[index++] =val;
	    }
	    for(int i=0;i<finalarray.length;i++)
	    {
	     System.out.println(finalarray[i]);
	    }
	}
public static List<Integer> primeprior(int [] arr)
	{
	List<Integer>resprime = new ArrayList<>();
	//int resprime[]=new int[arr.length];
	for (int i = 0; i < arr.length; i++) {
	            boolean isPrime = true;
	            if (arr[i] == 1)
	                isPrime = false;
	            else {
	                // check to see if the numbers are prime
	                for (int j = 2; j <= arr[i] / 2; j++) {
	                    if (arr[i] % j == 0) {
	                        isPrime = false;
	                        break;
	                    }
	                }
	            }
	            // print the number
	            if (isPrime)
	            resprime.add(arr[i]);   
	        }
	return resprime;
	}
public static List<Integer>twopower(int [] arr,List<Integer> firstpriorarr)
	{
	for(int i=0;i<arr.length;i++)
	{
	int num=arr[i];
	if((num&(num-1))==0&&num!=1&&num!=2)
	{
	firstpriorarr.add(num);
	}
	}
	return firstpriorarr;
	}
public static List<Integer>regular(int [] arr,List<Integer>secondprior)
	{
	for(int j=0;j<arr.length;j++)
	{
	int num =arr[j];
	     boolean flag = false;
	     for(int i = 2; i <= num/2; ++i)
	     {
	         // condition for nonprime number
	         if(num % i == 0)
	         {
	             flag = true;
	             break;
	         }
	     }

	     if (!flag)
	     {
	   
	     }
	     else if((num&(num-1))==0&&num!=1&&num!=2)
	     {
	   
	     }
	     else
	     {
          secondprior.add(num);
         }
      }
  return secondprior;
 }
}

