import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;

public class NumberRangeSummarizerTest {
    @Test
    public void testCollect(){
        //Creates new instance of NumberRangeSummarizer
        NumberRangeSummarizer numberRangeSummarizerImplementation = new NumberRangeSummarizerImplementation();
        //Call method to test
        Collection<Integer> result = numberRangeSummarizerImplementation.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        //Create expectedResult collection to compare
        Collection<Integer>  expectedResult = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        //Compares expectedResult with result
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSummarizeCollection(){
        //Creates new instance of NumberRangeSummarizer
        NumberRangeSummarizer numberRangeSummarizerImplementation = new NumberRangeSummarizerImplementation();
        //Called method to test with input values
        String result = numberRangeSummarizerImplementation.summarizeCollection(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        //Create expected result
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        //Compares expectedResult with
        Assert.assertEquals(expectedResult, result);
    }
}
