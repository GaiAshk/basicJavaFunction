import java.util.StringTokenizer;

public class CensoredStringTokenizer {

    public static void main(String[] args) {

        /*
        *//*
        // Still doesnt work perfectlty, problem with printing the last word of a censoredStringToken
        *//*
        */
        String text = "eat the apple or the banana but not the sushi";
        String[] censor = {"the", "or", "and", "not"};
        CensoredStringTokenizer cStr = new CensoredStringTokenizer(text, censor);
        while(cStr.hasMoreTokens()) {
            System.out.println(cStr.nextToken());
        }

        }

    // fileds of the Object
    private String[] censoredWords;       //The words to be censored
    private StringTokenizer tokenizer;    //Used to break the text to tokens
    private String nextUncensoredToken;   //The next un censored token

    public CensoredStringTokenizer(String text, String[] censoredWords) {
        this.censoredWords = censoredWords;
        this.tokenizer = new StringTokenizer(text);
        while(this.tokenizer.hasMoreTokens()) {
            String s = this.tokenizer.nextToken();
            if(!isCensored(s)) {
                this.nextUncensoredToken = s;
                break;
            }
        }
    }

    private void skip() {
        while(this.tokenizer.hasMoreTokens()) {
            String s = this.tokenizer.nextToken();
            if (!isCensored(s)) {
                this.nextUncensoredToken = s;
                return;
            }
        }
    }

    public String nextToken() {
        String s = this.nextUncensoredToken;
        skip();
        return s;
    }


    public boolean hasMoreTokens() {
        while(this.tokenizer.hasMoreTokens()) {
            if(!isCensored(this.nextUncensoredToken)) return true;
        }
        return false;
    }

    public boolean isCensored(String word) {
        for (int i = 0; i < this.censoredWords.length; i++) {
            if(equals(word, this.censoredWords[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(String s, String t) {
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // unrelated methods form a test

    public static void mystery(int x) {
        System.out.println(x % 10);
        if( (x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.println(x % 10);
    }

    public static double deposit(double sum, double rate, int n) {
        if(n == 0) return sum;
        return (deposit(sum * (1 + rate), rate, n-1));
    }

}




