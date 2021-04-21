package hot100;

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

    public String intToRoman2(int num) {
        String r = "";
        int count = 0;
        while (num != 0) {
            int pop = num % 10;
            // 从个位数向前不断迭代加
            r = getRoman(pop, count) + r;
            count++;
            num /= 10;
        }
        return r;
    }

    public String getRoman(int num, int count) { //count 表示当前的位数，个位，十位...
        char[] ten = {'I', 'X', 'C', 'M'}; //1,10,100,1000
        char[] five = {'V', 'L', 'D'};//5,50,500
        String r = "";
        if (num <= 3) {
            while (num != 0) {
                r += ten[count];
                num--;
            }
        }
        if (num == 4) {
            r = (ten[count] + "") + (five[count] + "");
        }
        if (num == 5) {
            r = five[count] + "";
        }
        if (num > 5 && num < 9) {
            r = five[count] + "";
            num -= 5;
            while (num != 0) {
                r += ten[count];
                num--;
            }
        }
        if (num == 9) {
            r = (ten[count] + "") + (ten[count + 1] + "");
        }
        return r;
    }

    public void test() {
//        System.out.println(intToRoman(3));
//        System.out.println(intToRoman(4));
//        System.out.println(intToRoman(9));
        System.out.println(intToRoman(79));
//        System.out.println(intToRoman(50));
//        System.out.println(intToRoman(1800));
//        System.out.println(intToRoman(2994));
    }
}
