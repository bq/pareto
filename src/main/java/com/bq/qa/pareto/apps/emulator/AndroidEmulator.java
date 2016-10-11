package com.bq.qa.pareto.apps.emulator;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import com.bq.qa.pareto.apps.util.Timer;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndroidEmulator {

    private final Logger paretoLogger = ParetoAppLogger.getLogger();

    private static final String EMULATOR_BIN_PATH = "/tools/emulator";
    private static final String ADB_BIN_PATH = "/platform-tools/adb";
    private static final String ANDROID_HOME = "ANDROID_HOME";

    private String adbBin;
    private String emulatorBin;
    private String emulatorName;
    private Process androidEmulator;
    private final String UDID;


    public AndroidEmulator(String UDID) {
        this.UDID = UDID;
        emulatorBin = System.getenv(ANDROID_HOME) + EMULATOR_BIN_PATH;
        adbBin = System.getenv(ANDROID_HOME) + ADB_BIN_PATH;
        emulatorName = ParetoApp.getAndroidConfig().android_emulatorname();
    }

    /**
     * Gets a device UDID
     *
     * @return a device UDID
     */
    public String getUDID() {
        return UDID;
    }

    /**
     * Starts the emulator
     */
    public void start() {
        try {
            androidEmulator = Runtime.getRuntime().exec(emulatorBin + " -avd " + emulatorName +" -port "+ParetoApp.getAndroidConfig().android_emulatorport());

            while(!isInitialized()){
                Timer.waitSeconds(5);
                paretoLogger.debug("Loading Android Emulator...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isInitialized() throws IOException {
        boolean initialized = false;
        String command= adbBin+" -s "+ "emulator-"+ParetoApp.getAndroidConfig().android_emulatorport()+" shell getprop sys.boot_completed";
        androidEmulator=Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(androidEmulator.getInputStream()));

        // read the output from the command
        String s = null;
        while ((s = stdInput.readLine()) != null) {
                initialized = s.equals("1");
        }
        return initialized;
    }
    /**
     * Stops the emulator
     */
    public void stop() {
        paretoLogger.debug("Stopping Android Emulator...");
        androidEmulator.destroyForcibly();
    }

}
