class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int totalLen = n + m - 1;
        
        char[] res = new char[totalLen];
        boolean[] fixed = new boolean[totalLen];

        // --- Step 1: Handle 'T' (Mandatory) Constraints ---
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int currIdx = i + j;
                    // If this spot was already set by another 'T' and conflicts
                    if (fixed[currIdx] && res[currIdx] != str2.charAt(j)) {
                        return "";
                    }
                    res[currIdx] = str2.charAt(j);
                    fixed[currIdx] = true;
                }
            }
        }

        // --- Step 2: Initial Lexicographical Fill ---
        // Fill all gaps not determined by 'T' with 'a'
        for (int i = 0; i < totalLen; i++) {
            if (!fixed[i]) {
                res[i] = 'a';
            }
        }

        // --- Step 3: Handle 'F' (Must-Not-Match) Constraints ---
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                // If the current substring accidentally matches str2
                if (checkMatch(res, i, str2)) {
                    boolean adjusted = false;
                    // Try to change the rightmost non-fixed character in this window
                    // Changing the rightmost char minimizes lexicographical impact
                    for (int j = i + m - 1; j >= i; j--) {
                        if (!fixed[j]) {
                            // Since it matched str2 and we filled gaps with 'a',
                            // res[j] is currently 'a'. Changing it to 'b' breaks the match.
                            res[j] = 'b';
                            adjusted = true;
                            break;
                        }
                    }
                    // If no character in the window could be changed, it's impossible
                    if (!adjusted) return "";
                }
            }
        }

        // --- Step 4: Final Validation ---
        // Ensure that our 'F' adjustments didn't accidentally create a match elsewhere
        for (int i = 0; i < n; i++) {
            boolean isMatch = checkMatch(res, i, str2);
            if (str1.charAt(i) == 'T' && !isMatch) return "";
            if (str1.charAt(i) == 'F' && isMatch) return "";
        }

        return new String(res);
    }

    private boolean checkMatch(char[] res, int start, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (res[start + j] != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}