package net.taoziyoyo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // 使该 Bean 能在配置刷新时动态更新
public class GatewayController {

    @Value("${some.config.value}")
    private String configValue;

    @GetMapping("/config")
    public String getConfigValue() {
        return this.configValue;
    }
}