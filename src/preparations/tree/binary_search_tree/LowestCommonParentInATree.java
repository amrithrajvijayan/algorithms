package preparations.tree.binary_search_tree;
import java.util.*;

/*
<p>
  You're given three inputs, all of which are instances of an
  <span>OrgChart</span> class that have a <span>directReports</span> property
  pointing to their direct reports. The first input is the top manager in an
  organizational chart (i.e., the only instance that isn't anybody else's direct
  report), and the other two inputs are reports in the organizational chart. The
  two reports are guaranteed to be distinct.
</p>
*/

public class LowestCommonParentInATree {
	private static int checkReportees(OrgChart node, OrgChart reportOne, OrgChart reportTwo, List<OrgChart> retList) {
		
		if (node == null)
			return 0;
		
		if (retList.size() > 0)
			return 0;
		
		int count = 0;
		if (node.name == reportOne.name || node.name == reportTwo.name) 
			count = 1;
		
		for (OrgChart report : node.directReports) {
			count = count + checkReportees(report, reportOne, reportTwo, retList);
		}
		if (count == 2)
			retList.add(node);
		
		return count;
	}
	
	
	
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    
		List<OrgChart> retList = new ArrayList<>();		
		checkReportees(topManager, reportOne, reportTwo, retList);
		
    return retList.get(0);
  }

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
}
