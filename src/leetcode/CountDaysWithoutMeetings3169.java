package leetcode;

import java.util.Arrays;

public class CountDaysWithoutMeetings3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (o1, o2) -> (o1[0] - o2[0]));
        int cntDays = meetings[0][0] - 1;
        int end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            if (start > end) cntDays += start - end - 1;
            end = Math.max(end, meetings[i][1]);
        }

        if (days > end) return days - end + cntDays;
        return cntDays;
    }
}
