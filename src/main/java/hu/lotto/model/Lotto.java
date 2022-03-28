package hu.lotto.model;

import hu.lotto.exception.InvalidLottoNumberCountException;
import hu.lotto.exception.InvalidLottoTypeException;

import java.util.Optional;
import java.util.Set;

public interface Lotto {

    Set<Integer> generate();
    Optional<Integer> validate(Set<Integer> setOfTips, Set<Integer> resultSet) throws InvalidLottoNumberCountException, InvalidLottoTypeException;
}
