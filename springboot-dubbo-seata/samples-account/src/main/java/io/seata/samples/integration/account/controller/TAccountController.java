package io.seata.samples.integration.account.controller;

import io.seata.samples.integration.account.service.ITAccountService;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 账户扣钱
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class TAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TAccountController.class);

    @Autowired
    private ITAccountService accountService;

    @PostMapping("/dec_account")
    ObjectResponse decreaseAccount(@RequestBody AccountDTO accountDTO) {
        LOGGER.info("请求账户微服务：{}", accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }

    @GetMapping("/test")
    String test() {
        return "OK";
    }
}

