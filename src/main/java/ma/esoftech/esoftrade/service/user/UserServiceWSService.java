
package ma.esoftech.esoftrade.service.user;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UserServiceWSService", targetNamespace = "User.Service.esoftrade.esoftech.ma", wsdlLocation = "http://localhost:9999/userService?wsdl")
public class UserServiceWSService
    extends Service
{

    private final static URL USERSERVICEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException USERSERVICEWSSERVICE_EXCEPTION;
    private final static QName USERSERVICEWSSERVICE_QNAME = new QName("User.Service.esoftrade.esoftech.ma", "UserServiceWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9999/userService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERSERVICEWSSERVICE_WSDL_LOCATION = url;
        USERSERVICEWSSERVICE_EXCEPTION = e;
    }

    public UserServiceWSService() {
        super(__getWsdlLocation(), USERSERVICEWSSERVICE_QNAME);
    }

    public UserServiceWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERSERVICEWSSERVICE_QNAME, features);
    }

    public UserServiceWSService(URL wsdlLocation) {
        super(wsdlLocation, USERSERVICEWSSERVICE_QNAME);
    }

    public UserServiceWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERSERVICEWSSERVICE_QNAME, features);
    }

    public UserServiceWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserServiceWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "UserServicePort")
    public UserService getUserServicePort() {
        return super.getPort(new QName("User.Service.esoftrade.esoftech.ma", "UserServicePort"), UserService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserService
     */
    @WebEndpoint(name = "UserServicePort")
    public UserService getUserServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("User.Service.esoftrade.esoftech.ma", "UserServicePort"), UserService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERSERVICEWSSERVICE_EXCEPTION!= null) {
            throw USERSERVICEWSSERVICE_EXCEPTION;
        }
        return USERSERVICEWSSERVICE_WSDL_LOCATION;
    }

}
