package org;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.sonar.java.ast.visitors.CognitiveComplexityVisitor;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

public class Understandability {
	
	public static void main(String args[]) {
		String path = "C:\\Users\\carlo\\Downloads\\VEM_LLMs_Readability\\Replication Package\\Step 4 - Code Readability Issues\\1 - Extract Issues\\data";
		if (path == null || path.equals("")) {
			System.out.println("Can't receive file");
		}
		File root = new File(path);
		searchDirs(root);
		
	}
	
	private static void searchDirs(File root) {
		if (!root.isDirectory()) {
			if (root.getName().endsWith(".java")) {
				calculateMetric(root);
			}			
		} else {
			File[] files = root.listFiles();
			for (File file: files) {
				searchDirs(file);
			}
		}
		
	}

	static void calculateMetric(File file) {
		CheckUnderstandability check = new CheckUnderstandability();
		String path = file.getAbsolutePath();
		CheckVerifier.newVerifier()		
		  .onFile(path)
	      .withCheck(check)
	      .verifyNoIssues();
		
		Double metric = check.getTotal().doubleValue();

		File parentDir = file.getParentFile();

		File outputFile = new File(parentDir, "cognitive_complexity.csv");

		try (FileWriter fw = new FileWriter(outputFile);  
			PrintWriter pw = new PrintWriter(fw)) {			
			pw.println(metric);
		} catch (IOException e) {
			e.printStackTrace();    
		}
		System.out.println(metric);
	}
}

class CheckUnderstandability extends IssuableSubscriptionVisitor {

	Integer total = 0;

	@Override
	public List<Tree.Kind> nodesToVisit() {
		return Arrays.asList(Tree.Kind.METHOD, Tree.Kind.CONSTRUCTOR);
	}

	@Override
	public void visitNode(Tree tree) {
		MethodTree method = (MethodTree) tree;
		CognitiveComplexityVisitor.Result result = CognitiveComplexityVisitor.methodComplexity(method);
		total += result.complexity;
	}

	public Integer getTotal() {
		return total;
	}
	
	
}
