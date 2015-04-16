package ma.esoftech.esoftrade.controller.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SpringSessionScopedBeanDeprefixer implements HttpSessionAttributeListener {
	 
    private static final String PREFIX = "scopedTarget.";
 
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.startsWith(PREFIX)) {
            HttpSession session = event.getSession();
            Object value = event.getValue();
            session.setAttribute(name.substring(PREFIX.length()), value);
        }
    }
 
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.startsWith(PREFIX)) {
            HttpSession session = event.getSession();
            session.removeAttribute(name.substring(PREFIX.length()));
        }
    }
 
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.startsWith(PREFIX)) {
            HttpSession session = event.getSession();
            Object value = session.getAttribute(name);
            session.setAttribute(name.substring(PREFIX.length()), value);
        }
    }
 
}