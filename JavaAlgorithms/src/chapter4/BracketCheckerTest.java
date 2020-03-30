package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketCheckerTest {

    @Test
    public void shouldReturnSuccessfullyIfStringContainsNoErrors(){
        String correct = "[ass{assa{assa}as}saa](asssas{asssa})ass";
        assertDoesNotThrow(() -> BracketChecker.check(correct));
    }

    @Test
    public void shouldThrowIAEWhenClosingWithNotMatchingBracket(){
        String closingWithWrongBracket = "{a(a]a}";
        IllegalArgumentException ex
                = assertThrows(IllegalArgumentException.class, () -> BracketChecker.check(closingWithWrongBracket));

        System.out.println(ex.getMessage());
    }

    @Test
    public void shouldThrowIAEWhenForgotToCloseBracket(){
        String lineWithoutClosingBracket = "{a(b)";
        IllegalArgumentException ex
                = assertThrows(IllegalArgumentException.class, () -> BracketChecker.check(lineWithoutClosingBracket));
        System.out.println(ex.getMessage());
    }

    @Test
    public void shouldThrowIAEWhenHaveRedundantClosingBrackets(){
        String lineWithRedundantClosingBracket = "{a(b)}}";
        IllegalArgumentException ex
                = assertThrows(IllegalArgumentException.class, () -> BracketChecker.check(lineWithRedundantClosingBracket));
        System.out.println(ex.getMessage());
    }
}