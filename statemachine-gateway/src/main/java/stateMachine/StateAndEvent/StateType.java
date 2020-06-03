package stateMachine.StateAndEvent;


import stateMachine.Machine.StateMachineLevel;

public enum StateType {
    Null("没有玩游戏"),

    Preparing("准备开始游戏"),

    InService("正在玩游戏"),

    Finished("游戏已结束");

    private String display;

    private StateMachineLevel level;

    StateType(String display){
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public StateMachineLevel getLevel() {
        return level;
    }
}
