package com.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.sonarsource.sonarlint.core.rpc.protocol.client.issue.RaisedIssueDto;

public class Main {

    private SonarLintExecutor sonarLintExecutor = new SonarLintExecutor();

    public static void main(String[] args) throws Exception {

        Main main = new Main();

        File currentDirectory = new File(System.getProperty("user.dir"));

        File parentDirectory = currentDirectory.getParentFile();

        File rootDir = new File(parentDirectory, "data");

        File[] projectsDir = rootDir.listFiles();
        Arrays.sort(projectsDir, Comparator.comparingInt(f -> Integer.parseInt(f.getName())));

        int countProjects = 1;

        for (File projectDir : projectsDir) {
            System.out.println("Processing project " + countProjects + " ------- " + projectDir.getName());
            Integer projeto = Integer.parseInt(projectDir.getName());
            if (projeto > 349) {
                main.processProject(projectDir);            
            }            
            countProjects++;                        
        }
    }

    private void processProject(File projectDir) throws Exception {

        for (File baseline : projectDir.listFiles()) {
            processBaseline(baseline);
        }
    }

    //baseline = before, after, chatgpt generated readability improvement, etc.
    private void processBaseline(File baseline) throws Exception {
        List<File> javaFiles = getJavaFiles(baseline);
        for (File javaFile : javaFiles) {
            String javaFileName = javaFile.getName();
            List<RaisedIssueDto> issues = sonarLintExecutor.executa(javaFile);
            writeIssues(issues, baseline, javaFileName);
        }
    }

    private static void writeIssues(List<RaisedIssueDto> issues, File project, String javaFileName) throws Exception {
        File file = new File(project.getAbsolutePath() + "/sonarLintAnalysis_version_10.22.0.81232_" + javaFileName + ".csv");
        PrintWriter pw = new PrintWriter(file);
        pw.println("rule key,start line,end line,severity,message,type");
        for (RaisedIssueDto issue : issues) {
            String ccAttr = "";
            if (issue.getSeverityMode() != null && issue.getSeverityMode().getRight() != null) {
                ccAttr = issue.getSeverityMode().getRight().getCleanCodeAttribute().toString();
            }
            String startLine = issue.getTextRange() == null ? "null" : issue.getTextRange().getStartLine() + "";
            String endLine = issue.getTextRange() == null ? "null" : issue.getTextRange().getEndLine() + "";
            pw.println(issue.getRuleKey() + "," + startLine + "," + endLine + "," + ccAttr
                    + "," + issue.getPrimaryMessage() + "," + issue.getRuleDescriptionContextKey() + ",");
        }
        pw.close();
    }

    private static List<File> getJavaFiles(File directory) {
        List<File> javaFiles = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        javaFiles.addAll(getJavaFiles(file));
                    } else if (file.isFile() && file.getName().endsWith(".java")) {
                        javaFiles.add(file);
                    }
                }
            }
        }

        return javaFiles;
    }

}
