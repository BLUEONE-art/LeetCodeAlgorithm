package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {

    public static void main(String[] args) {
        try {
            ServerSocket server= new ServerSocket(10808);
            while (true) {
                Socket socket = server.accept();
                //读取服务信息
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String interfaceName = inputStream.readUTF();//接口名称
                String methodName = inputStream.readUTF();//方法名称
                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();//参数类型
                Object[] parameters = (Object[]) inputStream.readObject();//参数对象
                Class<?> serviceInterfaceClass = Class.forName(interfaceName);
//				Object service = services.get(interfaceName);
                //服务端将事先实例化好的服务放在services这个Map中，通过interfaceName取出使用
                Object service = new SayHelloServiceImpl();//演示代码直接new了一个对象来使用
                //获取要调用的方法
                Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, parameters);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                //将执行结果返回给调用端
                outputStream.writeObject(result);
                System.out.println("Parameters from comsumer: " + parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源...
        }
    }
}
