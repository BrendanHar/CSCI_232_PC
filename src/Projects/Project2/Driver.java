package Projects.Project2;

import java.io.File;

/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dictionaryFile = new File("src/Projects/Project2/words.txt");
        File processingFile = new File("src/Projects/Project2/test.txt");
        DocCheck.spellCheck(processingFile, dictionaryFile);
        DocCheck.wordCount(processingFile);
    }
}
