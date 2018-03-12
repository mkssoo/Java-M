import java.lang.*;
import java.io.*;
public class ba {
	public static void main(String args[]) throws IOException {
		long start,end;
		start=System.currentTimeMillis();
		BufferedWriter f_write = new BufferedWriter(new FileWriter(args[2]));
		int n = Integer.parseInt(args[0]); //ノード数
		int k = Integer.parseInt(args[1]); //平均リンク数
		int link = n*k/2; //結ぶリンク数

		int[] array1 = new int[n*3+1]; //array1[0]は使わない
		int[] array2 = new int[n*3+1]; //array2[0]は使わない
		int[] dice   = new int[12+n*k+1]; //dice[0]は使わない,2,3行下のfor文で配列12個使うので+12にした
		int count =1;
		for(int i=1;i<=4;i++){ //各ノード[1,1,1,2,2,2,3,3,3,4,4,4]を代入
			for(int j=1;j<=3;j++){
				array1[count]=i;
				dice[count]=i; //array1と同じ内容の配列を作る
				count++;
			}
		}

		count=1;
		for(int p=1;p<=4;p++){   //完全グラフを作るために
			for(int q=1;q<=4;q++){ //それぞれに対応するリンク先を指定する
				if(p!=q){            //[2,3,4,1,3,4,1,2,4,1,2,3]を代入
					array2[count]=q;
					count++;
				}
			}
		}

		int dice_num=12;
		int array_num=13;
		int dice_count=12;
		int x=5;
		while(x<=n){ //ノード5から全ノードまで
			for(int y=1;y<=3;y++){
				dice[dice_num+1] = x;
				dice[dice_num+2] = dice[(int)(dice_count*Math.random()+1)];
				array1[array_num]=dice[dice_num+1];
				array2[array_num]=dice[dice_num+2];
				dice_num+=2;
				array_num++;
				if(y==2 && dice[dice_num]==dice[dice_num-2]){
					y--;
					dice_num-=2;
					array_num--;
				}
				if( y==3 && (dice[dice_num]==dice[dice_num-2] || dice[dice_num]==dice[dice_num-4]) ){
					y--;
					dice_num-=2;
					array_num--;
				}
			}
			x++;
			dice_count+=6;
		}


		f_write.write("*Vertices "+args[0]+"\n");
		for(count=1;count<n+1;count++){
			f_write.write(count+ " " + "\"" + count + "\"" + " " + "ic Red"+"\n");
		}

		long start2,end2;
		start2=System.currentTimeMillis();
		f_write.write("*Edges"+"\n");
		for(count=1;count<n*3+1;count++){
			f_write.write(array1[count]+" "+array2[count]+" "+1+"\n");
		}
		f_write.close();
		end2=System.currentTimeMillis();
		end=System.currentTimeMillis();
		System.out.println("全体"+(end-start)+"ミリ秒");
		System.out.println((end2-start2)+"ミリ秒");
	}
}
