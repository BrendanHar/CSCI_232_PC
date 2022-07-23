package Projects.Project2;

/**
 *
 * @author yaw
 */
import java.io.*;
import java.util.*;

public class DocCheck {

    public static void spellCheck(File processingFile, File dictionaryFile) {
        HashSet<String> dictionary = new HashSet<>();
        String text = "";
        try {
            Scanner dict = new Scanner(new FileReader(dictionaryFile));
            Scanner s = new Scanner(new FileReader(processingFile));
            while(s.hasNextLine()){
                text += s.nextLine();
            }
            while (dict.hasNextLine()){
                dictionary.add(dict.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println("Original Text: ");
//        System.out.println(text);
        String[] textCompare;

        //Splits string by all punctuation and spaces only leaving the words
        textCompare = text.split("((?=[^a-zA-Z])|(?<=[^a-zA-Z]))");
        String[] sentence = text.split("\\W+");
        int index =0;

        HashSet<String> output = new HashSet<>();
        for (String word : textCompare){
            output.add(word);
        }

        for (String word : sentence){
            if (!dictionary.contains(word.toLowerCase(Locale.ROOT))) {
                index = 0;
                for (String element : textCompare){
                    if (element.equals(word)){
                        textCompare[index] = "<"+ word +">";
                    }
                    index++;
                }
            }
        }
        System.out.println();



        //Prints out the output of the spellchecked sentence
//        System.out.println("Spellchecked Text:");
        String fileOutput = "";
        for (String word : textCompare){
            fileOutput += word;
        }

        //writes all the stuff to file
        try {
            File file = new File("_spellChecked.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter("_spellChecked.txt");
            writer.write(fileOutput);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void wordCount(File processingFile) {
        HashMap<String, Integer> countPerWord = new HashMap<>();
        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();
        String text = "";
        try {
            Scanner s = new Scanner(processingFile);
            while(s.hasNextLine()){
                text += s.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //create an array of strings to count all words
        String[] textCompare;
        String[] sentence = text.split("\\W+");

        // \\s and \\s+ can be used to represent single and multiple white spaces
        //Puts all words into a hashmap if not already in the hashmap
        for (String word : sentence){
            if (!countPerWord.containsKey(word.toLowerCase(Locale.ROOT))){
                countPerWord.put(word.toLowerCase(Locale.ROOT), 1);
            }
            // get the current count of the word and add 1 to the value that associated with the word
            else{
                int x = countPerWord.get(word.toLowerCase(Locale.ROOT));
                countPerWord.put(word.toLowerCase(Locale.ROOT), x + 1);
            }
        }

        int count = 0;
        for (String word : sentence){
            if (!wordsPerCount.containsKey(countPerWord.get(word.toLowerCase(Locale.ROOT)))){
                wordsPerCount.put(countPerWord.get(word), new HashSet<>());
                count++;
            }
            wordsPerCount.get(countPerWord.get(word)).add(word.toLowerCase(Locale.ROOT));
        }
        wordsPerCount.remove(null);
        String[] alphaArr = new String[countPerWord.size()];
        int index = 0;

        //creates a alphabetized array
        for (String e: countPerWord.keySet() ){
            alphaArr[index] = e;
            index++;
        }
        Arrays.sort(alphaArr);


        //This code did not work to print out the hashset - decided to use an iterator
//        System.out.print(wordsPerCount);
//        for (int i = 0; i < count; i++) {
//            System.out.print(i + ": ");
//            if (wordsPerCount.get(count) != null){
//                for (String element : wordsPerCount.get(count)) {
//                    System.out.print(element + ", ");
//                }
//            }
//            System.out.println();
//        }

        //Iterates through the hashmap and hashset
        String countPerWordOutput = "";
        Iterator<Map.Entry<Integer, HashSet<String>>> x = wordsPerCount.entrySet().iterator();
        while (x.hasNext()){
            Map.Entry<Integer, HashSet<String>> entry = x.next();
            countPerWordOutput += (entry.getKey() + ". ");
            Iterator<String> y = entry.getValue().iterator();
            while (y.hasNext()){
                countPerWordOutput += (y.next() + ", ");
            }
            countPerWordOutput += "\n";

        }

        //writes all the stuff to file
        try {
            File fileCreate = new File("_wordCount.txt");
            if (!fileCreate.exists()){
                fileCreate.createNewFile();
            }
            FileWriter file = new FileWriter("_wordCount.txt");
            file.write("Alphabetic order word count: " + "\n");
            for (String word: alphaArr){
                file.append(word + ": " +countPerWord.get(word) + "\n");
            }
            file.append("\n" + "By occurance word count: " + "\n");
            file.append(countPerWordOutput);

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
