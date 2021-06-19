package preparations.arrays;

import java.util.Arrays;

/*

  You're given a non-empty array of positive integers representing the amounts
  of time that specific queries take to execute. Only one query can be executed
  at a time, but the queries can be executed in any order.
  
  A query's waiting time is defined as the amount of time that it must
  wait before its execution starts. In other words, if a query is executed
  second, then its waiting time is the duration of the first query; if a query
  is executed third, then its waiting time is the sum of the durations of the
  first two queries.

  Write a function that returns the minimum amount of total waiting time for all
  of the queries. For example, if you're given the queries of durations
  [1, 4, 5], then the total waiting time if the queries were
  executed in the order of [5, 1, 4] would be
  (0) + (5) + (5 + 1) = 11. The first query of duration
  5 would be executed immediately, so its waiting time would be
  0, the second query of duration 1 would have to wait
  5 seconds (the duration of the first query) to be executed, and
  the last query would have to wait the duration of the first two queries before
  being executed.

*/

public class MinimumWaitTimeForQueries {
	public int minimumWaitingTime(int[] queries) {

		if (queries.length == 0 || queries.length == 1)
			return 0;

		int overallMinWaitTime = 0;
		Arrays.sort(queries);
		int prevTime = 0;
		for (int i = 1; i < queries.length; i++) {
			prevTime = prevTime + queries[i - 1];
			overallMinWaitTime = overallMinWaitTime + prevTime;
		}

		return overallMinWaitTime;
	}

}
