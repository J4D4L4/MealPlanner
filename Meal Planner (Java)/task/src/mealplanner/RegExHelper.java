package mealplanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHelper {

    public static boolean mealNamevalidation(String input){
        input = input.replace(" ","xxxx");
        String nameStringPattern = "(\\W|\\d)";
        Pattern namePattern = Pattern.compile(nameStringPattern,Pattern.CASE_INSENSITIVE);
        Matcher matcher = namePattern.matcher(input);
        if(input.length()<=1)
            return false;
        return !matcher.find();
    }

}
