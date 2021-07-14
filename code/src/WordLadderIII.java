import java.util.*;

public class WordLadderIII {
    public List<String> findLadder(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, String> graph = new HashMap<>();
        boolean found = false;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                String cur = queue.poll();
                List<String> nexts = transform(cur, wordDict);
                for (String next: nexts) {
                    graph.put(next, cur);
                    if (wordDict.remove(next)) {
                        queue.offer(next);
                    }
                    if (next.equals(endWord)) {
                        return getPath(graph, endWord, beginWord);
                    }
                }
            }
        }
        return res;
    }

    private List<String> getPath(Map<String, String> graph, String start, String target) {
        List<String> path = new LinkedList<>();
        String cur = start;
        while (!cur.equals(target)) {
            path.add(0, cur);
            cur = graph.get(cur);
        }
        path.add(0, cur);
        return path;
    }

    private List<String> transform(String word, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char orig = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == orig) {
                    continue;
                }
                chars[i] = ch;
                String next = String.valueOf(chars);
                if (wordDict.contains(next)) {
                    res.add(next);
                }
            }
            chars[i] = orig;
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadderIII sol = new WordLadderIII();
        List<String> res = sol.findLadder("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        Utils.printList(res);
        res = sol.findLadder("hit", "cog", Arrays.asList("hot","dot", "lot","log","cog"));
        Utils.printList(res);
    }
}
