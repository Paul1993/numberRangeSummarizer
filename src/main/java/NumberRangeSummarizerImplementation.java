import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {
        //Create new ArrayList named result
        Collection<Integer> result = new ArrayList<>();
        try{
            //Split input values into string array by comma separation
            String[] split = input.split(",");
            //Loops through split string array
            for (String item : split) {
                //Parse string value to integer and add to result List
                result.add(Integer.parseInt(String.valueOf(item)));
            }
        }catch(Exception error){
            System.out.println("Incorrect input");
        }
        //Return collection
        return result;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        //Cast object array to integer array
        Integer[] a = (Integer[]) input.toArray();
        //Sort array ascending
        Arrays.sort(a);
        //Create 2 dimensional arraylist called listMain
        List<List<Integer>> listMain = new ArrayList<>();
        //Create temporary list to work with
        List<Integer> temp = new ArrayList<>();
        //Add first element in array
        temp.add(a[0]);

        for (int i = 0; i < a.length - 1; i++) {
            //Check if next value is equal to current value + 1
            if (a[i + 1] == a[i] + 1) {
                //add it to temp arraylist
                temp.add(a[i + 1]);
            } else {
                //Add temp list to main list
                listMain.add(temp);
                //Reset temp list
                temp = new ArrayList<>();
                //Add next value to temp list
                temp.add(a[i + 1]);
            }
        }
        //Add temp list to main list
        listMain.add(temp);
        //Create new stringBuilder to append output
        StringBuilder builder = new StringBuilder();
        //Loop through list of grouped lists
        for (List<Integer> list : listMain) {
            //Check if list is a group
            if (list.size() > 1) {
                //Append first number in list, separate with - and add last value of list
                builder.append(list.get(0)).append("-").append(list.get(list.size() - 1));
            } else {
                //Append only item in list
                builder.append(list.get(0));
            }
            //Separate each item with comma and space
            builder.append(", ");
        }
        //Build string result
        String result = builder.toString();
        //Remove last comma and space from string and return result;
        return result.substring(0, result.length() - 2);
    }
}
