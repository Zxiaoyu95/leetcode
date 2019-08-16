package JiKeTest;

public class ListAddDel {
	public int find1(int[] array1,int n,int key){
		if(array1 == null || n<=0){
			return -1;
		}
		int i =0;
		while(i <n){
			if(array1[i] == key){
				return i;
			}
			i++;
		}
		return -1;
	}
	public int find2(int[] array2,int n,int key){
		if(array2 ==null || n<=0){
			return -1;
		}
		if(array2[n-1] == key){
			return n-1;
		}
		int tmp =array2[n-1];
		array2[n-1]=key;
		int i=0;
		while(array2[i] != key){
			i++;
		}
		array2[n-1]=tmp;
		if(i==n-1){
			return -1;
		}
		else{
			return i;
		}
	}
	public static void main(String[] args) {
		ListAddDel l1 =new ListAddDel();
		int[] array={1,3,4,2,65,4,5};
		int answer1=l1.find1(array, 6, 2);
		int answer2=l1.find2(array, 6, 2);
		System.out.println("ц╩спиз╠Ь--"+answer1+'\n'+"спиз╠Ь---"+answer2);
	}
}
