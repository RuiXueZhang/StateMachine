package stateMachine.StateAndEvent;

public abstract class StateEventBase{

    public enum EventType{

        InstanceApplySuccess("游戏申请成功"),

        InstanceRelease("游戏已释放");

        private String display;

        EventType(String display){
            this.display = display;
        }
    }

    private EventType eventType;

    public StateEventBase(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}
