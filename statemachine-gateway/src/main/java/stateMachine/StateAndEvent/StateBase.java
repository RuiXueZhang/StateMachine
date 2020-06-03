package stateMachine.StateAndEvent;

import cn.ruix.stateMachine.Machine.StateMachine;

import java.util.HashMap;
import java.util.Map;

public class StateBase {

   private StateType stateType;

   private StateMachine stateMachine;

    private static Map<StateType, Class<? extends StateBase>> map = new HashMap<>();

   public StateBase(StateType stateType){
       this.stateType = stateType;
       map.put(this.stateType, this.getClass());
   }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public static Class<? extends StateBase> getClazz(StateType stateType){return map.get(stateType);}

    public StateType getStateType() {
        return stateType;
    }
}
