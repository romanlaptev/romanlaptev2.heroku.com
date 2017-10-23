//Role: webserver with JSP support
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class runServer {
    public static void main( String[] args ) throws Exception 
	{
		Server server = new Server( Integer.valueOf( System.getenv("PORT") ) );
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("src/main/webapp");
		//ctx.setResourceBase("notes");
		ctx.setContextPath("/");
		
		ctx.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		//ctx.setDescriptor("notes/WEB-INF/web.xml");

		ctx.setResourceBase("src/main/webapp");
		//ctx.setResourceBase("notes");
		
		ctx.setParentLoaderPriority(true);
		server.setHandler(ctx);

		try {
			server.start();
			server.join();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
		
    }
}// runServer