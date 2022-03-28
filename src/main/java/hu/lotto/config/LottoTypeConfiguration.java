package hu.lotto.config;

import hu.lotto.config.impl.LottoTypeProviderImpl;
import hu.lotto.model.impl.LottoType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LottoTypeConfiguration {
    @Bean
    LottoTypeProvider lottoTypeProvider(){
        return new LottoTypeProviderImpl(LottoType.Five);
    }
}
