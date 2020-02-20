public class RestSpringBootApiGatewayRequestHandler
  extends SpringBootRequestHandler<APIGatewayProxyRequestEvent,
  APIGatewayProxyResponseEvent> {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private FunctionInspector inspector;

    @Autowired
    ApplicationContext ctx;

    // Constructors

    protected Object convertEvent(APIGatewayProxyRequestEvent event) {

        Object body = "";

        if (event.getBody() != null) {
            body = deserializeBody(event.getBody());
        }
        if (functionAcceptsMessage()) {
            return new GenericMessage<Object>(body, getHeaders(event));
        } else {
            return body;
        }
    }

    private MessageHeaders getHeaders(APIGatewayProxyRequestEvent event) {
        Map<String, Object> headers = new HashMap<String, Object>();
        if (event.getHeaders() != null) {
            headers.putAll(event.getHeaders());
        }
        if (event.getQueryStringParameters() != null) {
            headers.putAll(event.getQueryStringParameters());
        }
        if (event.getPathParameters() != null) {
            headers.putAll(event.getPathParameters());
        }
        headers.put("httpMethod", event.getHttpMethod());
        headers.put("request", event);
        return new MessageHeaders(headers);
    }

    // Further methods from the actual
      SpringBootApiGatewayRequestHandler class
}
