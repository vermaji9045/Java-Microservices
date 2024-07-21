package com.bank.gatewayserver.filtersUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    public static final String CORRELATION_ID = "Publicbank-correlation-id";
    private static Logger logger = LoggerFactory.getLogger(FilterUtility.class);

    public String getCorrelationId(HttpHeaders httpHeaders)
    {
        if(httpHeaders.get(CORRELATION_ID)!=null)
        {
             List<String>requestHeaderList=httpHeaders.get(CORRELATION_ID);

             return requestHeaderList.stream().findFirst().get();

        }
        else
        {
            return null;
        }
    }
    public ServerWebExchange setRequestHeader(ServerWebExchange exchange,String name,String value)
    {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name,value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange,String correlationId)
    {
        return this.setRequestHeader(exchange,CORRELATION_ID,correlationId);
    }
}
