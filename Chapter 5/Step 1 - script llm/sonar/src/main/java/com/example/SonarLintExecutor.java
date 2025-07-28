package com.example;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;

import org.sonarsource.sonarlint.core.rpc.protocol.client.issue.RaisedIssueDto;
import org.sonarsource.sonarlint.core.rpc.protocol.common.ClientFileDto;
import org.sonarsource.sonarlint.core.test.utils.SonarLintBackendFixture;

import static utils.AnalysisUtils.analyzeFileAndGetIssues;
import utils.TestPlugin;

public class SonarLintExecutor {

    private static final String CONFIG_SCOPE_ID = "configScopeId";
    private static final String CONFIGURATION_SCOPE_ID = "configScopeId";

    public List<RaisedIssueDto> executa(File classeJava) {
        Path filePath = classeJava.toPath();
        URI fileUri = filePath.toUri();
        Path baseDir = classeJava.getParentFile().toPath();

        var client = SonarLintBackendFixture.newFakeClient()
                .withInitialFs(CONFIG_SCOPE_ID, baseDir, List.of(new ClientFileDto(
                        fileUri,
                        baseDir.relativize(filePath),
                        CONFIG_SCOPE_ID,
                        false,
                        null,
                        filePath,
                        null,
                        null,
                        true
                )))
                .build();

        var backend = SonarLintBackendFixture.newBackend()
                .withUnboundConfigScope(CONFIGURATION_SCOPE_ID)                
                .withStandaloneEmbeddedPluginAndEnabledLanguage(TestPlugin.JAVA)  
                .start(client);
                
        return analyzeFileAndGetIssues(fileUri, client, backend, CONFIG_SCOPE_ID);
    }

}
