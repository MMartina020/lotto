package hu.lotto.config.impl;

import hu.lotto.config.LottoTypeProvider;
import hu.lotto.model.impl.LottoType;
import lombok.Getter;
import lombok.Setter;

public class LottoTypeProviderImpl implements LottoTypeProvider, LottoTypeConsumer {
    private @Getter @Setter
    LottoType lottoType;
}
