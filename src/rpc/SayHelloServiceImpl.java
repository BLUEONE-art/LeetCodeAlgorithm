package rpc;

public class SayHelloServiceImpl implements SayHelloService{

    @Override
    public String sayHello(String arg) {
        return "Hello " + arg;
    }
}
