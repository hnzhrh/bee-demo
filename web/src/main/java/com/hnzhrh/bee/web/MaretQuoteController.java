package com.hnzhrh.bee.web;

import com.hnzhrh.bee.demo.api.MarketQuoteServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "市场报价服务")
@RestController("/marketQuote")
public class MaretQuoteController {
    @Resource
    private MarketQuoteServiceI marketQuoteServiceI;

    @ApiOperation(("数据刷入MySQL"))
    @GetMapping("/v1/loadData")
    public void query(){
        marketQuoteServiceI.loadData();
    }
}
