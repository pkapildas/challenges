import java.util.*; 
import java.util.regex.Matcher;
 import java.util.regex.Pattern;
  public class GroupBySuffix { 
    public static void main(String[] args) {
        List<String> elements = List.of("a", "b1", "b2", "b3", "c1", "c2", "c3", "d1", "d2", "d3");
        Map<String, List<String>> groupedElements = groupBySuffix(elements);
        groupedElements.forEach((suffix, group) -> { 
            System.out.println("Group " + suffix + ": " + group); });
         }
 public static Map<String, List<String>> groupBySuffix(List<String> elements) {
     Map<String, List<String>> groupedElements = new HashMap<>(); 
     Pattern pattern = Pattern.compile("(\\D+)(\\d*)"); 
     for (String element : elements) {
        Matcher matcher = pattern.matcher(element);
        if (matcher.matches()) { 
            String prefix = matcher.group(1);
            String suffix = matcher.group(2); 
            groupedElements .computeIfAbsent(suffix, k -> new ArrayList<>()) .add(element); 
        } 
    } 
    return groupedElements; 
} 

}