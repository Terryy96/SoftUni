import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Random rnd = new Random();

        for (int i = 0; i <words.size() ; i++) {
           int position =rnd.nextInt(words.size());
           String newWord = words.get(i);
           words.set(i, words.get(position));
           words.set(position, newWord);
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
