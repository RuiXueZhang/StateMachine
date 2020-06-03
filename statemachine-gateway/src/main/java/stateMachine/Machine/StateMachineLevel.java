package stateMachine.Machine;

public enum  StateMachineLevel {

    LEVEL_A("不占租户并发数，不占用户并发数",0,0),

    LEVEL_B("不占租户并发数，占用用户并发数",0,1),

    LEVEL_C("占用租户并发数，不占用户并发数",1,0),

    LEVEL_D("不占租户并发数，不占用户并发数",1,1)

    ;

    private String message;

    private int tenantConcurrency;

    private int userConcurrency;

    StateMachineLevel(String message, int tenantConcurrency, int userConcurrency) {
        this.message = message;
        this.tenantConcurrency = tenantConcurrency;
        this.userConcurrency = userConcurrency;
    }
}
