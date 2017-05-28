package io.kemper.api;

import java.util.Map;

/**
 * HTTP Response
 */
public class Response {
    private String body;
    private int statusCode;
    private Map<String, String> headers;
//    private boolean isBase64Encoded; //optional

    public Response() {}

    public Response(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (statusCode != response.statusCode) return false;
        if (body != null ? !body.equals(response.body) : response.body != null) return false;
        return headers != null ? headers.equals(response.headers) : response.headers == null;
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + statusCode;
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "body='" + body + '\'' +
                ", statusCode=" + statusCode +
                ", headers=" + headers +
                '}';
    }
}
