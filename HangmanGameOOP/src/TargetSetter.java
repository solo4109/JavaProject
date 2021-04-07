import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

class TargetSetter {
	
	private static final String[] WORDS;
    private static String errorMessage = null;
 
    static {
        Path wordsFile = Path.of(Constants.getWordsFileName());
        String[] words;
        try {
            words = Files.readAllLines(wordsFile, StandardCharsets.UTF_8).toArray(new String[0]);
        } catch (IOException e) { 
            errorMessage = e.getMessage();
            words = null;
        }
        WORDS = words; 
    }
 
    private final Random random = new Random();
 
    String getNext() {
        return WORDS[random.nextInt(WORDS.length)];
    }
 
    String getErrorMessage() {
        return errorMessage;
    }
}
