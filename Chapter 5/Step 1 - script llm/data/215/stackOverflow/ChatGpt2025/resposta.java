import java.util.List;

public class Teste {

    public void scheduleManagementEmail(ManagementEmailConfig managementEmailConfig, Scheduler scheduler) throws SchedulerException {
        logger.debug("Scheduling Management Email "
                + managementEmailConfig.getManagementEmailConfigId());

        String jobKey = "SendManagementEmailJob_"
                + managementEmailConfig.getManagementEmailConfigId();
        Class<? extends Job> jobClass = SendManagementEmailJob.class;
        JobDetail job = JobBuilder.newJob(jobClass).withIdentity(new JobKey(jobKey)).build();
        Trigger trigger = sendManagementEmailJob.getTriggerWithSchedule(managementEmailConfig);
        trigger.getJobDataMap().put("managementEmailConfigId", managementEmailConfig.getManagementEmailConfigId());
        if (!scheduler.checkExists(new JobKey(jobKey))) {
            scheduler.scheduleJob(job, trigger);
        }
        debugPrintJobs();
    }

    public void debugPrintJobs() {
        Scheduler scheduler = getScheduler();
        try {
            // All scheduled jobs
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    // Do something with the info you just got
                    // ...
                }
            }
        } catch (SchedulerException e) {
            log.error("Retrieving jobs", e);
        }
    }
}