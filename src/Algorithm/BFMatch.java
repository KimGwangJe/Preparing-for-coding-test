package Algorithm;

class Bf{
    public void bf(String a, String b){
        int temp = 0;
        int i;
        for(i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(temp)){
                temp++;
            } else{
                i = i - temp + 1;
                temp = 0;
            }

            if(temp == b.length()){
                System.out.println("있음");
                break;
            }
        }

    }
}
public class BFMatch {
    public static void main(String[] args){
        Bf bf = new Bf();
        bf.bf("ABABCDEFGHA","ABC");
    }
}
