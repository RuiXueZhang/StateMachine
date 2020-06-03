package stateMachine.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("haima.screen")
public class ScreenConfig {

    public static class DpiResolutionInfo {

        private String dpi;

        private String resolution;

        public String getDpi() {
            return dpi;
        }

        public void setDpi(String dpi) {
            this.dpi = dpi;
        }

        public String getResolution() {
            return resolution;
        }

        public void setResolution(String resolution) {
            this.resolution = resolution;
        }
    }

    private Map<String, DpiResolutionInfo> iosInfo = new HashMap<>();

    public Map<String, DpiResolutionInfo> getIosInfo() {
        return iosInfo;
    }

    public void setIosInfo(Map<String, DpiResolutionInfo> iosInfo) {
        this.iosInfo = iosInfo;
    }
}
