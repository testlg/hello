import java.util.*;
public class combination 
{
	Stack stack;
	public combination(){
		stack=new Stack<Integer>();
	}

	public void findCombination(int sum,int n)
	{
		if(sum<0||n<=0)return;
		if(sum==0){
			printStack();
			//System.out.println(sum);
			System.out.println();
		}
		stack.add(n);
		findCombination(sum-n,n-1);
		stack.pop();
		findCombination(sum,n-1);

	}
	 public  void permutation01(int sum,int n){  
        if(n<=0||sum<=0)return;  
        if(sum==n){  
            printStack();  
            System.out.print(n);  
            System.out.println();  
        }  
        stack.add(n);  
        permutation01(sum-n,n-1);  
        stack.pop();  
        permutation01(sum,n-1);  
    }  
      
	 public  void permutation02(int sum, int n) {  
        if(n<=0||sum<=0)return; 
		if(sum<n)
			n=sum;
        for (int i = n; i > 0; i--) {  
            if (i == sum) {  
                System.out.println(i);  
                continue;  
            }  
            List<Integer> list = new ArrayList<Integer>();  
            list.add(i);  
            for (int j = i - 1; j > 0;) {  
                list.add(j);  
                int ret = isOK(list, sum);  
                if (ret < 0) {  
                    j--;  
                }  
                if (ret == 0) {  
                    printList(list);  
                    System.out.println();  
                    //j = list.get(1) - 1;//now we go back and make the second element smaller  
                   // list.clear();  
                   // list.add(i);  
				   list.remove(list.size()-1);//too large,remove the last element  
                    j--;
                }  
                if (ret > 0) {  
                    list.remove(list.size()-1);//too large,remove the last element  
                    j--; 
                }  
            }  
        }  
    }  
	    public static int isOK(List<Integer> list, int sum) {  
        int re = 0;  
        int total = 0;  
        for (int each : list) {  
            total += each;  
        }  
        if (total > sum)  
            re = 1;  
        if (total < sum)  
            re = -1;  
        return re;  
  
    }  
  
    public void printStack(Stack<Integer> stack){  
        /* 
        while(!stack.isEmpty()){ 
            int temp=stack.pop(); 
            System.out.print(temp+" "); 
        } 
        */  
        //don't remove the elements in stack  
        for(Integer each:stack){  
            System.out.print(each+" ");  
        }  
    }  
  
  
    public  void printList(List<Integer> list) {  
        for (int each : list) {  
            System.out.print(each + " ");  
        }  
    }
	public void printStack()
	{
		while(!stack.empty())
		{
			System.out.println(stack.pop());
		}
	}
		public static void main(String[] args) 
	{
		combination com=new combination();
		//com.findCombination(10,6);
		com.permutation02(5,6);
	}
}
