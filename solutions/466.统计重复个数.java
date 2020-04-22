import java.util.*;
/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 */

// class Solution {
//     public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
//         if (s1 == null || s1.length() == 0 || n1 == 0)
//             return 0;
//         if (s2 == null || s2.length() == 0 || n2 == 0)
//             return 0;
//         if (impossibleMatch(s1, s2))
//             return 0;
//         int matched = 0, currentPos = 0; 
//         String lastRemain = "";
//         Map<String, MatchReport> reports = new HashMap<>();
//         while ((currentPos + lastRemain.length()) / s1.length() < n1) {
//             if (reports.containsKey(lastRemain)) {
//                 LoopReport loop = analyzeLoop(reports, lastRemain) ;
//                 int loops = (s1.length() * n1 - currentPos) / loop.passedChars;
//                 matched += loops * loop.matched;
//                 currentPos += loops * loop.passedChars;
//                 reports.clear();
//             } else {
//                 MatchReport report = match(lastRemain + s1, s2);
//                 reports.put(lastRemain, report);
//                 matched += report.matched;
//                 currentPos += report.passedChars;
//                 lastRemain = report.remain;
//             }
//         }
//         return matched / n2;
//     }

//     boolean impossibleMatch(String s1, String s2) {
//         Set<Character> c = new HashSet<>();
//         for (int i = 0; i < s2.length(); i ++)
//             c.add(s2.charAt(i));
//         for (int i = 0; i < s1.length(); i ++)
//             c.remove(s1.charAt(i));
//         return c.size() > 0;
//     }

//     MatchReport match(String s1, String s2) {
//         int matched = 0, end = 0;
//         for (int p1 = 0, p2 = 0; p1 < s1.length(); p1 ++) {
//             char c1 = s1.charAt(p1), c2 = s2.charAt(p2);
//             if (c1 == c2) {
//                 if (++p2 == s2.length()) {
//                     p2 = 0;
//                     matched ++;
//                     end = p1 + 1;
//                 }
//             }
//         }
//         return new MatchReport(matched, s1.substring(end), end);
//     } 

//     class MatchReport {
//         int matched;
//         String remain;
//         int passedChars;
//         MatchReport(int matched, String remain, int passedChars) {
//             this.matched = matched;
//             this.remain = remain;
//             this.passedChars = passedChars;
//         }
//     }

//     LoopReport analyzeLoop(Map<String, MatchReport> reports, String entrykey) {
//         int looplen = 0, matched = 0;
//         String key = entrykey;
//         do {
//             MatchReport report = reports.get(key);
//             looplen += report.passedChars;
//             matched += report.matched;
//             key = report.remain;
//         } while (!key.equals(entrykey));
//         return new LoopReport(matched, looplen);
//     }

//     class LoopReport {
//         int matched;
//         int passedChars;
//         LoopReport(int matched, int passedChars) {
//             this.matched = matched;
//             this.passedChars = passedChars;
//         }
//     }
// }


// class Solution {
//     public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
//         char[] row = s1.toCharArray(), col = s2.toCharArray();
//         int rl = row.length, cl = col.length;
//         int[] count = new int[cl + 1]; 
//         int[] index = new int[cl];
//         Arrays.fill(index, -1);
//         int rpCnt = 0, rpStart = -1, rpEnd = -1;
//         for (int c = 0, carriage = 0; c <= cl && c < n1; c ++) {
//             for (int r = 0; r < rl; r ++) {
//                 if (row[r] == col[carriage]) {
//                     if (++ carriage == cl) {
//                         carriage = 0;
//                         rpCnt ++;
//                     }
//                 }
//             }
//             for (int k = 0; k < c; k++) {
//                 if (index[k] == carriage) {
//                     rpStart = k;
//                     rpEnd = c;
//                     break;
//                 }
//             }
//             if (rpStart >= 0) {break;}
//             count[c] = rpCnt;
//             index[c] = carriage;
//         }
        
//         if (rpStart < 0) 
//             return count[n1] / n2;
//         int beforeRp = count[rpStart];
//         int inRp = (n1 - rpStart - 1) / (rpEnd - rpStart) * (rpCnt - count[rpStart]);
//         int afterRp = count[(n1 - rpStart - 1) % (rpEnd - rpStart) + rpStart] - count[rpStart];
//         return (beforeRp + inRp + afterRp) / n2;
//     }
// }


// @lc code=start
class Solution {
    public int getMaxRepetitions(String sentence, int sl, String row, int rl) {
        int cl = row.length();
        int[] offsets = new int[cl + 1], repeats = new int[cl + 1];
        int rpStart = -1, rpEnd = 0, line = 0;
        for (int i = 1, carriage = 0; i <= sl; i ++) {
            for (int j = 0; j < sentence.length(); j ++) {
                if (sentence.charAt(j) == row.charAt(carriage)) {
                    if (++ carriage == cl) {
                        carriage = 0;
                        line ++;
                    }
                }
            }
            for (int k = 0; k < i; k ++) {
                if (carriage == offsets[k]) { 
                    rpStart = k;
                    rpEnd = i;
                    break;
                }
            }
            if (rpStart >= 0) break;
            offsets[i] = carriage;
            repeats[i] = line;
        }
        if (rpStart < 0)
            return line / rl;
        int rpBody = sl - rpStart, rpLength = rpEnd - rpStart;
        int rpTimes = rpBody / rpLength, rpRemain = rpBody % rpLength;
        return (rpTimes * (line - repeats[rpStart]) 
                + repeats[rpStart] + repeats[rpRemain])
                / rl;
    }
}


// @lc code=end

