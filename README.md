# jaxws-in-out-interceptor
This project is an adaptation from [Mkyong´s articles](http://www.mkyong.com/webservices/jax-ws/jax-ws-soap-handler-in-server-side/). I´ve added Maven dependency management and a different way of add
inbound / outbound message handlers for a more flexible build.

## Service
To start the service (in **hello-server** folder):

```
$ mvn clean jetty:run
```

## Client
To start the client (with the service already started), just execute the main class: **helloservice.main.Client**.

It needs the service started  not just to invoke the service but also to load the WSDL from the service and generate the
artifacts on the fly. To use the local WSDL (already present in the project folder) just change the plugin configuration,
in POM file as below:

From:
```
<wsdlUrls>
	<wsdlUrl>http://localhost:8080/SimpleWebService?wsdl</wsdlUrl>
</wsdlUrls>
<!-- <wsdlFiles> -->
<!--   <wsdlFile>SimpleWebService.wsdl</wsdlFile> -->
<!-- </wsdlFiles> -->
```

To:
```
<!-- <wsdlUrls> -->
<!-- 	<wsdlUrl>http://localhost:8080/SimpleWebService?wsdl</wsdlUrl> -->
<!-- </wsdlUrls> -->
<wsdlFiles>
  <wsdlFile>SimpleWebService.wsdl</wsdlFile>
</wsdlFiles>
```

