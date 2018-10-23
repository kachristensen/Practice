package com.company;
import java.util.*;

/**Given n sentences and q queries, for each query print the number of sentences that contains all the words of the query.**/
public class QuerySentences {

  private static void querySentences(List<String> sentences, List<String> queries) {
    for (String query : queries) {
      query = query.toLowerCase();
      List<String> queryWords = Arrays.asList(query.split("[^\\w]"));
      int numMatches = 0;

      for (String sentence : sentences) {
        sentence = sentence.toLowerCase();
        List<String> stringWords = Arrays.asList(sentence.split("[^\\w]"));
        if (stringWords.containsAll(queryWords)){
          numMatches ++;
        }
      }
      System.out.println("The query \"" + query + "\"  has " + numMatches + " sentence(s) that contain all of its words.");
    }
  }

  public static void main(String[] args) {

    List<String> sentences = Arrays.asList("The cat was bad.", "The dog was good.", "This is good and bad.");
    List<String> queries = Arrays.asList("cat bad" , "the" , "was" , "good bad");

    querySentences(sentences, queries);

  }
}

