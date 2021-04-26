package string;

public class SolutionS005 {
    public String replaceSpace(String s) {
        int size = s.length();

        char[] chars = new char[size * 3];

        int j = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';

            } else {
                chars[j++] = c;
            }
        }
       return new String(chars, 0, j) ;
    }
}
