package fr.norsys.dojo.test;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import fr.norsys.dojo.model.ShoppingCart;
import fr.norsys.dojo.service.CartService;

public class DojoFlowExecutionTests extends AbstractXmlFlowExecutionTests {

	@Mock
    private CartService cartService;

    protected void setUp() {
    	MockitoAnnotations.initMocks(this);
    }

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
    	return resourceFactory.createFileResource("src/main/webapp/WEB-INF/shop/shop-flow.xml");
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
    	builderContext.registerBean("cartService", cartService);
    }

    public void testViewCart() {
    	setCurrentState("catalog");

    	MockExternalContext context = new MockExternalContext();
    	context.setEventId("cart");
    	resumeFlow(context);

    	assertCurrentStateEquals("cart");
    }
    
    public void testCheckoutEmptyCart() {
    	setCurrentState("cart");
    	getFlowScope().put("shoppingCart", new ShoppingCart());

    	MockExternalContext context = new MockExternalContext();
    	context.setEventId("checkout");
    	
    	resumeFlow(context);

    	assertCurrentStateEquals("errorEmptyCart");
    }
    
    public void testEndFlow() {
    	setCurrentState("catalog");

    	MockExternalContext context = new MockExternalContext();
    	context.setEventId("exit");
    	
    	resumeFlow(context);

    	assertFlowExecutionEnded();
    }

}
