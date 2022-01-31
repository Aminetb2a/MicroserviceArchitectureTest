package zuul.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO check to handle fall back errors https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html
public class FallBackController extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(FallBackController.class);
    protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set(SEND_ERROR_FILTER_RAN);
        // rest of your code
        return null;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // only forward to errorPath if it hasn't been forwarded to already
        return ctx.getThrowable() != null
                && !ctx.getBoolean(SEND_ERROR_FILTER_RAN, false);
    }
}
