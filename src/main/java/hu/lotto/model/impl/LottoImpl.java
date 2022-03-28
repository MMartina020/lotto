package hu.lotto.model.impl;

import hu.lotto.config.LottoTypeProvider;
import hu.lotto.exception.InvalidLottoNumberCountException;
import hu.lotto.exception.InvalidLottoTypeException;
import hu.lotto.model.Lotto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Lazy
@Component
@NoArgsConstructor
class LottoImpl implements Lotto {
    private Random random;
   private LottoTypeProvider lottoTypeProvider;

   @Autowired
    public void setLottoTypeProvider (LottoTypeProvider lottoTypeProvider) {
        this.lottoTypeProvider = lottoTypeProvider;
    }

    @PostConstruct
    void initialize() {
        this.random = new Random();
        System.out.println("lottó létrejött");
    }

    private Set<Integer> generateNumbers(int maxValue, int count) {
        Set<Integer> result = new HashSet<>();
        while (result.size() < count){
            result.add(this.random.nextInt(maxValue)+1);
        }
        return result;
    }

    private boolean isValid(Integer tip){
        return (this.lottoTypeProvider.getLottoType() == LottoType.Five)
                ? tip <= 90
                : tip <= 45;
    }

    private boolean isWrongTip(Integer tip, Set<Integer> values){
        return !values.contains(tip);
    }

    @Override
    public Set<Integer> generate(){
        return(lottoTypeProvider.equals(LottoType.Five))
            ? generateNumbers( 90, 5)
            : generateNumbers(45, 6);

    }

    @Override
    public Optional<Integer> validate(Set<Integer> setOfTips, Set<Integer> resultSet) throws InvalidLottoNumberCountException, InvalidLottoTypeException {
        int result = 0;
        if(setOfTips.size() != resultSet.size()) throws new InvalidLottoNumberCountException();
        for(Integer tip : setOfTips){
            if(!isValid(tip)) return Optional.empty();
            if(!isWrongTip(tip,resultSet)) result ++;
        }
        return Optional.of(result);
        }
    }

