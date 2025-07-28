import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Set;

public class QuartzJobLister {
    public static void main(String[] args) throws SchedulerException {
        // Get the scheduler instance
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
        // Get all job groups
        for (String groupName : scheduler.getJobGroupNames()) {
            // Get all jobs in the group
            Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));
            
            for (JobKey jobKey : jobKeys) {
                System.out.println("Found job: " + jobKey.getName() + " in group: " + jobKey.getGroup());
                
                // Get job detail if needed
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                System.out.println("    Description: " + jobDetail.getDescription());
                System.out.println("    Job Class: " + jobDetail.getJobClass().getName());
                
                // Get triggers for this job
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    System.out.println("    Trigger: " + trigger.getKey());
                    System.out.println("    Next Fire Time: " + trigger.getNextFireTime());
                }
            }
        }
    }
}
