package JVM;

import java.util.ArrayList;
// -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class Demo_OOM {
    byte[] array = new byte[1*1024*1024];  // 1M

    public static void main(String[] args) {
        ArrayList<Demo_OOM> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new Demo_OOM());
                count++;
            }
        } catch (Error e) {
            System.out.println("次数为=" + count);
        }


    }
}
