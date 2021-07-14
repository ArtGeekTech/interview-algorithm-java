import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }

        // build graph via BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, List<String>> graph = new HashMap<>();
        boolean found = false;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Set<String> levelVisited = new HashSet<>();
            while (sz-- > 0) {
                String cur = queue.poll();
                List<String> nexts = transform(cur, wordSet);
                for (String next: nexts) {
                    if (!graph.containsKey(next)) {
                        graph.put(next, new ArrayList<>());
                    }
                    graph.get(next).add(cur);
                    if (levelVisited.add(next)) {
                        queue.offer(next);
                    }
                    if (next.equals(endWord)) {
                        found = true;
                    }
                }
            }
            wordSet.removeAll(levelVisited);

            if (found) {
                // find all paths from endWord to beginWord
                List<String> path = new LinkedList<>();
                path.add(endWord);
                dfs(res, path, graph, endWord, beginWord);
                return res;
            }
        }

        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> graph, String cur, String target) {
        if (cur.equals(target)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String next: graph.get(cur)) {
            path.add(0, next);
            dfs(res, path, graph, next, target);
            path.remove(0);
        }
    }

    private List<String> transform(String word, Set<String> wordSet) {
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
                if (wordSet.contains(next)) {
                    res.add(next);
                }
            }
            chars[i] = orig;
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadderII sol = new WordLadderII();
        List<List<String>> res = sol.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        Utils.printLists(res);
    }
}
