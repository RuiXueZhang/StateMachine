package stateMachine.Machine;

import cn.ruix.stateMachine.StateAndEvent.StateBase;
import cn.ruix.stateMachine.StateAndEvent.StateEventBase;
import cn.ruix.stateMachine.StateAndEvent.StateType;
import org.springframework.stereotype.Component;

@Component
public class StateMachine {

   private StateMachineContext context;

   private StateBase stateBase;

   private StateMachineFactory machineFactory = new StateMachineFactory();

    public StateBase getStateBase() {
        return stateBase;
    }

    public void setStateBase(StateBase stateBase) {
        this.stateBase = stateBase;
    }

    public void changeState(StateType to, StateEventBase.EventType eventType){
      StateType from = stateBase == null ? null : stateBase.getStateType();
      Integer userId = context.getData().getPerson().getUserId();
      StateType stateType = from == null ? to : from;
      dochangState(to , eventType);
   }

   public void dochangState(StateType to, StateEventBase.EventType eventType){
       StateType stateType = stateBase == null ? null : stateBase.getStateType();
       Integer userId  = context.getData().getPerson().getUserId();
       Integer schoolId = context.getData().getPersonInfo().getSchoolId();
       if(stateBase != null){
           StateBase stateBase = machineFactory.creatState(this, stateType);
           if(stateBase != null){
               System.out .println("class: SateMachine ;method: dochangeState; fromState: "+stateType+"toState:"+to+"success");
           }else {
               System.out .println("class: SateMachine ;method: dochangeState; fromState: "+stateType+"toState:"+to+"failed");
           }
       }else{
           StateBase stateBase = machineFactory.creatState(this, stateType);
           if(stateBase != null){
               System.out .println("class: SateMachine ;method: dochangeState; fromState: "+stateType+"toState:"+to+"success");
           }else {
               System.out .println("class: SateMachine ;method: dochangeState; fromState: "+stateType+"toState:"+to+"failed");
           }
       }
   }
    public StateMachineContext getContext() {
        return context;
    }

    public void setContext(StateMachineContext context) {
        this.context = context;
    }

    public void handleEvent(){



    }
}
