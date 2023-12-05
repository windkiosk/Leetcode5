package daily_coding;

// https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
public class ShortestUniquePrefix {

  private static class TrieNode {
    TrieNode nodes[] = new TrieNode[256];
    int degree = 0;
  }

  static TrieNode initTree(String[] list) {
    TrieNode root = new TrieNode();
    for (String s : list) {
      TrieNode curr = root;
      for (char c : s.toCharArray()) {
        if (curr.nodes[c] == null) {
          curr.nodes[c] = new TrieNode();
        }
        curr.nodes[c].degree ++;
        curr = curr.nodes[c];
      }
    }

    return root;
  }

  public static void main(String[] args){
    String[] ret = findShortestUniquePrefix(new String[]{"dog", "cat", "apple", "apricot", "fish"});
    for (String s : ret) {
      System.out.println(s);
    }
  }

  static String[] findShortestUniquePrefix(String[] list) {
    TrieNode root = initTree(list);

    String[] ret = new String[list.length];
    for (int i = 0; i < list.length; i ++) {
      ret[i] = findPrefix(root, list[i]);
    }
    return ret;
  }

  static String findPrefix(TrieNode root, String s) {
    StringBuilder stringBuilder = new StringBuilder();
    TrieNode curr = root;
    for (char c : s.toCharArray()) {
      stringBuilder.append(c);
      if (curr.nodes[c].degree == 1) {
        break;
      }
      curr = curr.nodes[c];
    }
    return stringBuilder.toString();
  }
}
