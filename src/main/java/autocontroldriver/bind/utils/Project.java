package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Project {

    private final DriverManager driverManager;

    /**
     * class init with driver manager
     *
     * @param driverManager driver manager that manage driver:
     */
    public Project(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String createProject(String projectPath, String parentName) {
        return driverManager.sendCommand(
                String.format(
                        "[[\"create_project\", {\"project_path\": \"%s\", \"parent_name\": \"%s\"}]]",
                        projectPath, parentName
                )
        );
    }

    public String createProject(String projectPath) {
        return driverManager.sendCommand(
                String.format(
                        "[[\"create_project\", {\"project_path\": \"%s\"}]]",
                        projectPath
                )
        );
    }


}
