import java.util.*;

public class NGramGenerator {
    public static void main(String[] args) {
        String line = "2,the";
        String text = "Mary had a little lamb its fleece was white as snow; And everywhere that Mary went, the lamb was sure to go. It followed her to school one day, which was against the rule; It made the children laugh and play, to see a lamb at school. And so the teacher turned it out, but still it lingered near, And waited patiently about till Mary did appear. \"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.";

        String[] input = line.split(",");
        Integer value = Integer.parseInt(input[0]);
        String word = input[1];

        System.out.println(
            String.join(
                ";",
                getResultsList(
                    nGramGenerator(text,value,word)
                )
            )
        );
    }

    private static String[] getWordArray(String text) {
        // clean up and split text into list
        List<String> wordList = new ArrayList<>(Arrays.asList(text.toLowerCase().replaceAll("[^a-z]", ",").split(",")));
        // remove empty entries
        wordList.removeIf(s -> s.equals(""));
        return wordList.toArray(new String[0]);
    }

    private static Map<String, Integer> nGramGenerator(String text, Integer value, String word) {
        Map<String, Integer> nGrams = new HashMap<>();
        String[] wordArray = getWordArray(text);

        // reduce by value amount to prevent null pointers & make sure full n-gram value is found for each instance
        for (int i = 0; i < wordArray.length - value; i++) {
            if (wordArray[i].equals(word)) {
                // create array of words following target word
                String[] nextWords = new String[value - 1];
                int index = 0;
                for (int j = i + 1; j < i + value; j++) {
                    nextWords[index] = wordArray[j];
                    index++;
                }
                // turn array into string
                String nGram = String.join(" ", nextWords);
                // add string to map as key, total occurrences as value
                int count = nGrams.getOrDefault(nGram, 0);
                nGrams.put(nGram, count + 1);
            }
        }

        return nGrams;
    }

    private static List<String> getResultsList(Map<String, Integer> map) {
        List<String> resultsList = new ArrayList<>();
        // total times word has occurred ... i'm sure there are easier ways to get this
        int nGramTotal = map.entrySet().stream().mapToInt(Map.Entry::getValue).sum();

        // sort map and then feed into list
        map.entrySet().stream()
                // comparing by value does ascending, need to reverse
            .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue()
                // need to un-reverse for alphabetically by key
            .thenComparing(Collections.reverseOrder(Map.Entry.comparingByKey()))))
            .forEach(e -> resultsList.add(
                String.format("%s,%.3f", e.getKey(), (float) e.getValue()/nGramTotal))
            );

        return resultsList;
    }

}
