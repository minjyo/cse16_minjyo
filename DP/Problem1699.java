import java.util.*;

public class Problem1699 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int square[] = new int[N+1];

        if((int) Math.sqrt(N)* (int) Math.sqrt(N)==N){
            square[N]=1;
        }else{
            for(int i=0; i<=N; i++){
                square[i] = i;
            }
            for(int i=4; i<=N; i++) {  //1->1, 2->2, 3->3
                for (int j = 1; j*j <= i; j++) {
                    square[i] = Math.min(square[i], 1 + square[i - j * j]);
                }
            }
        }


        System.out.println(square[N]);
    }

}
