package com.woolbro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {
    // 우선 추가 먼저 해주고, 이후에 작성 하도록 하겠습니다.
}