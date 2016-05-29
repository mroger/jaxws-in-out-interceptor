package helloservice.endpoint;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="SimpleWebService")
@HandlerChain(file="handler-chain.xml")
public class SimpleWebService {
    private String message = new String("Hello, ");

    public SimpleWebService() {
    }

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
