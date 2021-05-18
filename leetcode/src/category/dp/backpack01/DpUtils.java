package category.dp.backpack01;

public class DpUtils {
    public static void dump(int[][] dp) {
        StringBuilder builder = new StringBuilder();
        for (int[] arr : dp) {
            for (int i : arr) {
                builder.append(i).append(",");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static void dump(int[] dp) {
        StringBuilder builder = new StringBuilder();
        for (int i : dp) {
            builder.append(i).append(",");
        }
        builder.append("\n");

        System.out.println(builder.toString());
    }

    public static void dump(boolean[][] dp) {
        StringBuilder builder = new StringBuilder();
        for (boolean[] arr : dp) {
            builder.append("\n");
            for (boolean i : arr) {
                builder.append(i).append(",");
            }
        }
        System.out.println(builder.toString());
    }

    public static void dump(boolean[] dp) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (boolean i : dp) {
            builder.append(i).append(",");
        }
        System.out.println(builder.toString());
    }
}
