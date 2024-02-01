import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DecryptMessage {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\hung\\IdeaProjects\\learn SRV\\src\\input_DecryptMessage.txt"));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n==0){
                return;
            }
            String str=sc.next();
            String s[] = new String[str.length()/n];
            for(int i=0;i<str.length()/n;i++){
                s[i]="";//Khoi tao
                if(i%2==0){
                    for(int k=i*n;k<n+n*i;k++){
                        s[i]=s[i]+str.charAt(k);
                    }
                }else{
                    for(int k=i*n;k<n+n*i;k++){
                        s[i]=str.charAt(k)+s[i];
                    }
                }
                //System.out.println(s[i]);
            }

            for(int i=0;i<n;i++){
                for(int k=0;k<s.length;k++){
                    System.out.print(s[k].charAt(i));
                }
            }
            System.out.println();

        }

    }


}
