package stateMachine.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties("haima.notifycode")
public class NotifyConfig {

    private List<Map<String, String>> notifyMap;

    public List<Map<String, String>> getNotifyMap() {
        return notifyMap;
    }

    public void setNotifyMap(List<Map<String, String>> notifyMap) {
        this.notifyMap = notifyMap;
    }
}
