package Algorithm;

class BM{
    public int bm(String a, String b){
        int pt;
        int pp;
        int alen = a.length();
        int blen = b.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for(pt = 0; pt <= Character.MAX_VALUE; pt++){
            skip[pt] = blen;
        }
        for(pt = 0; pt < blen - 1; pt++){
            skip[b.charAt(pt)] = blen - pt - 1;
        }

        while(pt<alen){
            pp = blen - 1;

            while(a.charAt(pt) == b.charAt(pp)){
                if(pp == 0){
                    return pt;
                }
                pp--;
                pt--;
            }
            pt += (skip[a.charAt(pt)] > blen - pp) ? skip[a.charAt(pt)] : blen - pp;
        }
        return -1;
    }
}
public class BoyerMoore {
    public static void main(String[] args){
        BM bm = new BM();
        int a = bm.bm("ABCXDEZCABACABAC","ABAC");
        System.out.println(a);
    }
}
