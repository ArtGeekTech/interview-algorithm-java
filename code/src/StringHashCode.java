public class StringHashCode {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return 0;
        }
        long code = 0;
        for (char c: key) {
            code = (code * 33 + c) % HASH_SIZE;
        }

        return  (int) code % HASH_SIZE;
    }
}
