package helloservice.main;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import com.mkyong.handler.MacAddressInjectHandler;

import helloservice.endpoint.SimpleWebService;
import helloservice.endpoint.SimpleWebServiceService;

public class Client {

	public static void main(String[] args) {
		SimpleWebServiceService wsClient = new SimpleWebServiceService();
		wsClient.setHandlerResolver(new MyHandlerResolver());
		final SimpleWebService simpleWebServicePort = wsClient.getSimpleWebServicePort();
		System.out.println(simpleWebServicePort.sayHello("Guest"));
	}

	public static class MyHandlerResolver implements HandlerResolver {
		public List<Handler> getHandlerChain(PortInfo portInfo) {
			List<Handler> handlers = new ArrayList<Handler>();
			handlers.add(new MacAddressInjectHandler());
			return handlers;
		}
	}
}
