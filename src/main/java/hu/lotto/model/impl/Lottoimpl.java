package hu.lotto.model.impl;

import hu.lotto.model.Lotto;
import lombok.Getter;

import java.util.Set;

class Lottoimpl implements Lotto {
    private @Getter LottoType type;

    @Override
    public Set<Integer> generate (){
        return null;
    }
}
