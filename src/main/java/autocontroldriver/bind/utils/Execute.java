package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

import java.util.List;

public class Execute {

    private final DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Execute(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     *
     * @param filePath
     * @return
     */
    public String executeFile(List<String> filePath) {
        StringBuilder filePathBuilder = new StringBuilder();
        filePathBuilder.append("[[\"execute_files\", ").append("{").append("\"execute_files_list\": ");
        filePathBuilder.append("[");
        for (int index = 0; index < filePath.size(); index++) {
            if(index < filePath.size() - 1)
                filePathBuilder.append("\"").append(filePath.get(index)).append("\"").append(", ");
            else
                filePathBuilder.append("\"").append(filePath.get(index)).append("\"");
        }
        filePathBuilder.append("]}]]");
        return this.driverManager.sendCommand(filePathBuilder.toString());
    }

    /**
     *
     * @param packageName
     * @return
     */
    public String addPackageToExecutor(String packageName){
        return this.driverManager.sendCommand(
                String.format("[[\"add_package_to_executor\", {\"package\": \"%s\"}]]", packageName)
        );
    }

    /**
     *
     * @param packageName
     * @return
     */
    public String addPackageToCallBackExecutor(String packageName){
        return this.driverManager.sendCommand(
                String.format("[[\"add_package_to_callback_executor\", {\"package\": \"%s\"}]]", packageName)
        );
    }

}
