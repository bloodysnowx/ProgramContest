/* 1. 各人のジョブの合計時間を計算する
 * 2. ジョブの合計時間の少ない順にソートする
 * 3. 各人のジョブを順番に出力する */

using System;
using System.Linq;
using System.Collections.Generic;

namespace BatchSystem
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new BatchSystemSolver();
			var answer = solver.solve(new int[]{400, 100, 100, 100}, new string[]{"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"});
			printAnswer(answer);
			answer = solver.solve(new int[]{ 200, 200, 200 }, new string[]{ "Gil", "Sarah", "Warrick" });
			printAnswer(answer);
			answer = solver.solve(new int[]{ 100, 200, 50 }, new string[]{ "Horatio Caine", "horatio caine", "YEAAAAAAH" });
			printAnswer(answer);
		}

		private static void printAnswer(IEnumerable<int> answer) {
			System.Console.WriteLine(string.Join(", ", answer.Select(x => x.ToString()).ToArray()));
		}
	}

	class BatchSystemSolver
	{
		class Jobs {
			public class Job {
				public Job(int jobNumber, int duration) {
					this.jobNumber = jobNumber;
					this.duration = duration;
				}
				public int jobNumber { get; private set; }
				public int duration { get; private set; }
			}

			public IList<Job> jobs { get; private set; }
			string name;

			public Jobs(string name) {
				this.name = name;
				jobs = new List<Job>();
			}
			public void addJob(Job job) { this.jobs.Add(job); }
		}

		public IEnumerable<int> solve(int[] duration, string[] user) {
			IDictionary<string, Jobs> jobs = new Dictionary<string, Jobs>();
			for(int i = 0; i < Math.Min(duration.Length, user.Length); ++i) {
				if(!jobs.ContainsKey(user[i])) jobs.Add(user[i], new Jobs(user[i]));
				jobs[user[i]].addJob(new Jobs.Job(i, duration[i]));
			}
			foreach(var job in jobs.OrderBy(job => job.Value.jobs.Select(x => x.duration).Sum()))
				foreach(var x in job.Value.jobs)
					yield return x.jobNumber;
		}
	}
}
