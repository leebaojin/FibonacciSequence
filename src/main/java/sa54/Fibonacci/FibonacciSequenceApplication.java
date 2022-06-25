package sa54.Fibonacci;

import java.util.EnumSet;

import javax.inject.Singleton;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.internal.inject.AbstractBinder;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sa54.Fibonacci.api.FibonacciCalculateService;
import sa54.Fibonacci.resources.FiboResource;

public class FibonacciSequenceApplication extends Application<FibonacciSequenceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FibonacciSequenceApplication().run(args);
    }

    @Override
    public String getName() {
        return "FibonacciSequence";
    }

    @Override
    public void initialize(final Bootstrap<FibonacciSequenceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FibonacciSequenceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	
    	//Add the service layer
    	environment.jersey().register(new AbstractBinder() {
			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				bindAsContract(FibonacciCalculateService.class).in(Singleton.class);
			}
    		
    	});

    	//Create injection
    	final FiboResource  resource = new FiboResource(new FibonacciCalculateService());
    	
    	//Link resource
    	environment.jersey().register(resource);
    	
    	//Add the filter for cross origin
    	final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
    	
    	// Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost:3000");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    	
    	
    }

}
