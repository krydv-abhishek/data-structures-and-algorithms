package org.abhishek.arrays;

import java.util.ArrayList;
import java.util.List;

public class StringJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            int lineSize = 0;
            int j = i;
            int spaceLeft = 0;
            while ((j < words.length) && ((lineSize + (j - i) + words[j].length()) <= maxWidth)) {
                lineSize += words[j].length();
                j++;
            }
            if (j < words.length) {
                spaceLeft = maxWidth - lineSize;
            }

            if(j-i <=1) {
                String lastLine = words[i] + getSpaces(spaceLeft);
                lastLine = lastLine.concat(getSpaces(maxWidth-lastLine.length()));
                answer.add(lastLine);
                i++;
                continue;
            }
            

            int evenSpaces = spaceLeft / (j - i - 1);
            int remainderSpace = spaceLeft % (j - i - 1);
            if(j==words.length) {
                evenSpaces = 1;
            }
            String lineToBeAdded = "";
            while (i < j) {
                if (j - i - 1 > 0) {
                    lineToBeAdded = lineToBeAdded.concat(words[i] + getSpaces(evenSpaces));
                    if (remainderSpace > 0) {
                        lineToBeAdded = lineToBeAdded.concat(" ");
                        remainderSpace--;
                    }
                } else {
                    lineToBeAdded = lineToBeAdded.concat(words[i]);
                }
                i++;
            }
            
            lineToBeAdded = lineToBeAdded.concat(getSpaces(maxWidth-lineToBeAdded.length()));
            answer.add(lineToBeAdded);
        }
        return answer;

    }

    private static String getSpaces(int n) {
        int i = 0;
        String ans = "";
        while (i < n) {
            ans = ans.concat(" ");
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {

        // String[] strs = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
        //         "computer.", "Art", "is", "everything", "else", "we", "do" };
        // System.out.println(fullJustify(strs, 20));

        String[] str1 = { "This", "is", "an", "example", "of", "text", "justification." };
        System.out.println(fullJustify(str1, 16));

        // String[] str2 = { "What","must","be","acknowledgment","shall","be" };
        // System.out.println(fullJustify(str2, 16));

    }

}
