package sword;

public class Solution015 {
    public static void main(String[] args) {
        System.out.println(new Solution015().replaceSpace("We are happy."));
    }
    public String replaceSpace(String s) {
        int newlen = 0;
        int len = s.length();
        for(int i = 0; i < len ; i++) {
            if(s.charAt(i) == ' ') {
                newlen +=3;
            } else {
                newlen +=1;
            }
        }

        char[] arr = new char[newlen];
        int slow = len - 1;
        int fast = newlen -1;

        while (slow >= 0 && fast >= 0) {
            if(s.charAt(slow) == ' ') {
                arr[fast] = '0';
                arr[fast - 1] = '2';
                arr[fast - 2] = '%';
                fast -= 3;
            } else {
                arr[fast] = s.charAt(slow);
                fast --;
            }
            slow --;
        }
        return new String(arr);
    }
}
