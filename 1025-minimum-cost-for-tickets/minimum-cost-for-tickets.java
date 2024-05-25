class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] mem = new int[days.length];
        Arrays.fill(mem, -1);
        return helper(days, costs, 0, 0, mem);
    }

    public int helper(int[] days, int[] cost, int i, int passdays, int[] mem) {
        if(i == days.length) return 0;
        if(mem[i] != -1) return mem[i];
        int ans = 0;
        ans = Math.min(Math.min(cost[0]+helper(days, cost, getNextDayToBuy(i, days, 1), days[i]+0, mem), cost[1]+helper(days, cost, getNextDayToBuy(i, days, 7), days[i]+6, mem)), cost[2]+helper(days, cost, getNextDayToBuy(i, days, 30), days[i]+29, mem));
        mem[i] = ans;
        return ans;
    }

    private int getNextDayToBuy(int dayIndex, int[] days, int duration) {
        int endDay = days[dayIndex] + duration - 1;
        int newDayIndex = dayIndex;
		
        while (newDayIndex < days.length && days[newDayIndex] <= endDay) {
            newDayIndex++;
        }
        
        return newDayIndex;
    }
}