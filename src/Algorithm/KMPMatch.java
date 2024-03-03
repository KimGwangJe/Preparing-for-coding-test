package Algorithm;

class KMP{
    public void kmp(String a, String b){
        int pt = 1; // a 커서
        int pp = 0; // b 커서
        int[] skip = new int[b.length() + 1];
        skip[pt] = 0;

        // 건너뛰기 표 만들기
        while(pt != b.length()){
            if(b.charAt(pt) == b.charAt(pp)){
                skip[++pt] = ++pp;
            } else if(pp == 0){
                skip[++pt] = pp;
            } else{
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while(pt!=a.length() && pp!=b.length()){
            if(a.charAt(pt) == b.charAt(pp)){
                pt++;
                pp++;
            } else if(pp == 0){
                pt++;
            } else{
                pp = skip[pp];
            }

            if(pp == b.length()){
                System.out.println(pt - pp);
            }
        }
    }
}

public class KMPMatch {
    public static void main(String[] args){
        KMP kmp = new KMP();
        kmp.kmp("ABERABEABCAA","ABC");
    }
}
