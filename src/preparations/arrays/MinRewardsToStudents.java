package preparations.arrays;

import java.util.Arrays;

/*
  Imagine that you're a teacher who's just graded the final exam in a class. You
  have a list of student scores on the final exam in a particular order (not
  necessarily sorted), and you want to reward your students. You decide to do so
  fairly by giving them arbitrary rewards following two rules:
  

  All students must receive at least one reward.
  
    Any given student must receive strictly more rewards than an adjacent
    student (a student immediately to the left or to the right) with a lower
    score and must receive strictly fewer rewards than an adjacent student with
    a higher score.
  

  Write a function that takes in a list of scores and returns the minimum number
  of rewards that you must give out to students to satisfy the two rules.
  
*/

public class MinRewardsToStudents {
	public static int minRewards(int[] scores) {

		if (scores.length == 0)
			return 0;
		else if (scores.length == 1)
			return 1;

		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		int maxRewards = 0;

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > scores[i - 1])
				rewards[i] = rewards[i - 1] + 1;
		}

		for (int i = scores.length - 2; i >= 0; i--) {
			if (scores[i] > scores[i + 1]) {
				rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
			}
		}

		for (int reward : rewards) {
			maxRewards = maxRewards + reward;
		}

		return maxRewards;
	}
}
