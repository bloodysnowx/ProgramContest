using System;
using System.Collections.Generic;
using System.Linq;

/* 1. 上司/部下の木構造を作成する
 * 2. 再帰的に給料を計算していく */

namespace CorporationSalary
{
	public class CorporationSalarySolver
	{
		public int solve(String[] relations)
		{
			IList<Staff> staffList = createRelatedStaffList(relations);
			return (from staff in staffList select staff.getSalary()).Sum();
		}

		private IList<Staff> createRelatedStaffList(String[] relations) {
			IList<Staff> staffList = new List<Staff>(relations.Length);
			for(int i = 0; i < relations.Length; ++i) staffList.Add(new Staff());
			for(int i = 0; i < staffList.Count; ++i)
				for(int j = 0; j < relations[i].Length; ++j)
					if(relations[i][j] == 'Y') staffList[i].addSubordinate(staffList[j]);

			return staffList;
		}

		class Staff
		{
			private const int NOT_CALCULATED = -1;
			private int salary = NOT_CALCULATED;
			ISet<Staff> subordinates = new HashSet<Staff>();

			public int getSalary() {
				if(salary == NOT_CALCULATED) salary = (subordinates.Count == 0) ? 1 : (from subordinate in subordinates select subordinate.getSalary()).Sum();
				return salary;
			}

			public void addSubordinate(Staff staff) { subordinates.Add(staff); }
		}
	}
}

