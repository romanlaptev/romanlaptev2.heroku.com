//Role: webserver with JSP support
//https://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
//https://gist.github.com/sabadow/7076c1c6b52491505005
//https://examples.javacodegeeks.com/enterprise-java/jetty/jetty-jsp-example/

import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class FirstApp {
    public static void main( String[] args ) throws Exception 
	{
		Server server = new Server( Integer.valueOf( System.getenv("PORT") ) );
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("src/main/webapp");
		ctx.setContextPath("/");
		
		ctx.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		ctx.setResourceBase("src/main/webapp");
		ctx.setParentLoaderPriority(true);
		
		// ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");
		
        // // webapp.setAttribute(
                // // "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                // // ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$" );
				
		// //Configuration.ClassList classlist = Configuration.ClassList.setServerDefault( server );
		// //org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault( server );
		// // classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
		// // classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
		
		server.setHandler(ctx);

		
		try {
			server.start();
			server.join();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
		
    }
}// FirstApp

/*
//Role: Minimal Servlet
//https://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.*;

public class FirstApp {
    public static void main( String[] args ) throws Exception 
	{
		Server server = new Server( Integer.valueOf( System.getenv("PORT") ) );
		
		//ServletHandler handler = new ServletHandler();
		//server.setHandler(handler);
		
		//handler.addServletWithMapping(HelloServlet.class, "/*");

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet( new ServletHolder( new HelloServlet() ),"/*");
		
		try {
			server.start();
			server.join();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
		
    }
}// FirstApp

    class HelloServlet extends HttpServlet
    {
        @Override
        protected void doGet( HttpServletRequest request,
                              HttpServletResponse response ) throws ServletException,
                                                            IOException
        {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello from HelloServlet</h1>");
        }
    }
*/


/*
//Role: Simple File Server
//https://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html#embedded-file-server

//?import java.io.IOException;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class FirstApp {
    public static void main( String[] args ) throws Exception 
	{
		Server server = new Server( Integer.valueOf( System.getenv("PORT") ) );

		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed( true );
		resource_handler.setWelcomeFiles( new String[]{ "index.html" } );
		resource_handler.setResourceBase(".");
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
		server.setHandler(handlers);		
		server.start();
		server.join();
    }
}
*/