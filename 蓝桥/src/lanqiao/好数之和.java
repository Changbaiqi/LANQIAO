package lanqiao;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class 好数之和 extends java.io.CharArrayWriter {

    public static void main(String[] args) { new 好数之和().run(); }

    int N = (int)1e9, M = N / 666;

    String target = "2022";

    void run() {
        append("import java.util.Scanner;\n\n").
        append("public class Main {\n\n").
        append("    public static void main(String[] args) { new Main().run(); }\n\n").
        append("    void run() {\n").
        append("        Scanner in = new Scanner(System.in);\n").
        append("        int L = in.nextInt(), R = in.nextInt();\n").
        append("        System.out.print(calc(R) - calc(L - 1));\n    }\n\n").
        append("    long[] sum = { 0");
        Long sum = 0L;
        for (int i = 1; i <= N;) {
            for (int j = 1; j < M; ++j, ++i)
                if (Integer.toString(i).contains(target)) sum += i;
            append(", ").append(sum.toString()).append('L');
        }
        append(" };\n\n").
        append("    long calc(int n) {\n").
        append("        long res = sum[n / " + M + "];\n").
        append("        for (int i = n / " + M + " * " + M + "; i <= n; ++i)\n").
        append("            if (Integer.toString(i).contains(\"" + target + "\")) res += i;\n").
        append("        return res;\n    }\n}");
        Toolkit.getDefaultToolkit().
                getSystemClipboard().
                setContents(
                        new StringSelection(this.toString()), null);
    }
}
