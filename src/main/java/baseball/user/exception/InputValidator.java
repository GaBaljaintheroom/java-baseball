package baseball.user.exception;

import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String CHECK_USER_NUMBER = "숫자야구는 중복 안 되는 1~9 까지의 3글자 입니다.";
    private static final Character NUMBER_ZERO = '0';
    private static final int USER_NUMBER_SIZE = 3;

    public String validateUserNumberCorrect(String userNumber){
        validateUserNumberSize(andDuplicate(userNumber));
        return userNumber;
    }

    private void validateUserNumberSize(Set<Character> userNumber){
        if(userNumber.size() != USER_NUMBER_SIZE){
            throw new IllegalArgumentException(CHECK_USER_NUMBER);
        }
    }

    private Set<Character> andDuplicate(String userNumber) {
        return userNumber.chars()
                .mapToObj(c -> (char)c)
                .filter(Character::isDigit)
                .filter(c -> c != NUMBER_ZERO)
                .collect(Collectors.toSet());
    }

}