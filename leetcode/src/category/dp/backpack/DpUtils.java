package category.dp.backpack;

public class DpUtils {
    public static void dumpDp(int[][] dp) {
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
        for (int i :dp) {
            builder.append(i).append(",");
        }
        builder.append("\n");

        System.out.println(builder.toString());
    }
}
