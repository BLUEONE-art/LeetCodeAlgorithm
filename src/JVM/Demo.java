package JVM;

public class Demo {
    public static void main(String[] args) {
        // 返回虚拟机试图使用的最大内存(字节)
        long max = Runtime.getRuntime().maxMemory(); // byte --> 除以 1024 得KB --> 除以 1024 得 MB
        // 返回 JVM 初始化的总内存(字节)
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max虚拟机试图使用的最大内存=" + max + "字节\t" +
                "转换为MB=" + (max/(double)1024/1024) + "MB");

        System.out.println("total虚拟机初始化的总内存=" + total + "字节\t" +
                "转换为MB=" + (total/(double)1024/1024) + "MB");
    }
}
