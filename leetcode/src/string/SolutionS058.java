package string;

public class SolutionS058 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < n) {
            char c = arr[0];
            int j = 0;
            while (j < len - 1) {
                arr[j] = arr[j+1];
                j++;
            }
            arr[len - 1] = c;
            i ++;
        }
        return new String(arr);

//        int len = s.length();
//        int moves = len -n; // 移位次数，
//
//        int i = 0;
//        char[] arr = s.toCharArray();
//        while (i < moves) {
//            arr[i] = arr[i + n];
//            i++;
//        }
//
//        int j = 0;
//        while (j < n) {
//            arr[moves + j] = s.charAt(j);
//            j++;
//        }
//        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.print(new SolutionS058().reverseLeftWords("abcdefg", 2));
    }
}
