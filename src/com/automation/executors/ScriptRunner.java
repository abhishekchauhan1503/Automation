package com.automation.executors;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScriptRunner {
    private static final String EXECUTE_PERMISSIONS_SCRIPT_PATH = "src/com/automation/scripts/add-execute-permissions.sh";

    public void runBashScript(String pathToScript, String arg1, String arg2) {
        addExecutePermissions(pathToScript);
        runScript(pathToScript, arg1, arg2);
    }

    public void addExecutePermissions(String pathToScript) {
        runScript(EXECUTE_PERMISSIONS_SCRIPT_PATH, pathToScript, "");
    }

    private void runScript(String pathToScript, String arg1, String arg2) {
        try {
            ProcessBuilder pb = new ProcessBuilder(pathToScript, arg1, arg2);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ScriptRunner runner = new ScriptRunner();
        runner.runBashScript("src/com/automation/scripts/ls.sh", "", "");
    }
}
