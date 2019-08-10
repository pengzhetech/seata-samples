package io.seata.samples.integration.call.controller;

import io.seata.samples.integration.call.service.BusinessService;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @Author: heshouyou
 * @Description Dubbo业务执行入口
 * @Date Created in 2019/1/14 17:15
 */
@RestController
@RequestMapping("/business/dubbo")
@Slf4j
public class BusinessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    private BusinessService businessService;

    /**
     * http://127.0.0.1:8104//business/dubbo/buy
     * <p>
     * <p>
     * {
     * "userId":"1",
     * "commodityCode":"C201901140001",
     * "name":"伟大的哲哥",
     * "count":10,
     * "amount":10
     * <p>
     * }
     * <p>
     * 模拟用户购买商品下单业务逻辑流程
     *
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ObjectResponse handleBusiness(@RequestBody BusinessDTO businessDTO) {
        LOGGER.info("请求参数：{}", businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }

    /**
     * http://127.0.0.1:8104//business/dubbo/getBuy
     * @return
     */
    @GetMapping("/getBuy")
    ObjectResponse handleGetBusiness() {
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setUserId("1");
        businessDTO.setAmount(BigDecimal.TEN);
        businessDTO.setCommodityCode("C201901140001");
        businessDTO.setCount(10);
        businessDTO.setName("哲哥");
        return businessService.handleBusiness(businessDTO);
    }

}
