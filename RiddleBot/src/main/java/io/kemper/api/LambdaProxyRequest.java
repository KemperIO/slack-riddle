package io.kemper.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class LambdaProxyRequest {
    public String resource;
    public String path;
    public String httpMethod;
    public Map<String, String> headers;
    public Map<String, String> queryStringParameters;
    public Map<String, String> pathParameters;
    public Map<String, String> stageVariables;
    public Map<String, Object> requestContext;
    public String body;
    public boolean isBase64Encoded;

    public LambdaProxyRequest() {
    }

    public LambdaProxyRequest(String resource, String path, String httpMethod, Map<String, String> headers, Map<String, String> queryStringParameters, Map<String, String> pathParameters, Map<String, String> stageVariables, Map<String, Object> requestContext, String body, boolean isBase64Encoded) {
        this.resource = resource;
        this.path = path;
        this.httpMethod = httpMethod;
        this.headers = headers;
        this.queryStringParameters = queryStringParameters;
        this.pathParameters = pathParameters;
        this.stageVariables = stageVariables;
        this.requestContext = requestContext;
        this.body = body;
        this.isBase64Encoded = isBase64Encoded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaProxyRequest request = (LambdaProxyRequest) o;

        if (isBase64Encoded != request.isBase64Encoded) return false;
        if (resource != null ? !resource.equals(request.resource) : request.resource != null) return false;
        if (path != null ? !path.equals(request.path) : request.path != null) return false;
        if (httpMethod != null ? !httpMethod.equals(request.httpMethod) : request.httpMethod != null) return false;
        if (headers != null ? !headers.equals(request.headers) : request.headers != null) return false;
        if (queryStringParameters != null ? !queryStringParameters.equals(request.queryStringParameters) : request.queryStringParameters != null)
            return false;
        if (pathParameters != null ? !pathParameters.equals(request.pathParameters) : request.pathParameters != null)
            return false;
        if (stageVariables != null ? !stageVariables.equals(request.stageVariables) : request.stageVariables != null)
            return false;
        if (requestContext != null ? !requestContext.equals(request.requestContext) : request.requestContext != null)
            return false;
        return body != null ? body.equals(request.body) : request.body == null;
    }

    @Override
    public int hashCode() {
        int result = resource != null ? resource.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (httpMethod != null ? httpMethod.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (queryStringParameters != null ? queryStringParameters.hashCode() : 0);
        result = 31 * result + (pathParameters != null ? pathParameters.hashCode() : 0);
        result = 31 * result + (stageVariables != null ? stageVariables.hashCode() : 0);
        result = 31 * result + (requestContext != null ? requestContext.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (isBase64Encoded ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LambdaProxyRequest{" +
                "resource='" + safeToString(resource) + '\'' +
                ", path='" + safeToString(path) + '\'' +
                ", httpMethod='" + safeToString(httpMethod) + '\'' +
                ", headers=" + safeToString(headers) +
                ", queryStringParameters=" + safeToString(queryStringParameters) +
                ", pathParameters=" + safeToString(pathParameters) +
                ", stageVariables=" + safeToString(stageVariables) +
                ", requestContext=" + safeToString(requestContext) +
                ", body='" + safeToString(body) + '\'' +
                ", isBase64Encoded=" + safeToString(isBase64Encoded) +
                '}';
    }

    private String safeToString(Object o) {
        return o == null ? "null" : o.toString();
    }

    public Map<String, String> parseBody() {
        String tempBody = null;
        try {
            tempBody = URLDecoder.decode(this.body, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, String> requestBody = new HashMap<>();

        String[] keypairs = tempBody.split("&");
        for(String keypair : keypairs) {
            String[] temp = keypair.split("=");
            if(temp.length == 2) {
                requestBody.put(temp[0], temp[1]);
            }
        }

        return requestBody;
    }

}
