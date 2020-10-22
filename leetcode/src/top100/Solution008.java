package top100;

public class Solution008 {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public void test() {
//        System.out.println(intToRoman(3));
//        System.out.println(intToRoman(4));
//        System.out.println(intToRoman(9));
        System.out.println(intToRoman(79));
        System.out.println(intToRoman(50));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(2994));
    }
}
