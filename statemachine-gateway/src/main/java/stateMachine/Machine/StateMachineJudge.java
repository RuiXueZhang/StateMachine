package stateMachine.Machine;

import cn.ruix.stateMachine.StateAndEvent.StateType;
import cn.ruix.stateMachine.VirtualToolsClass.Person;
import org.springframework.stereotype.Component;

@Component
public class StateMachineJudge {

  interface TenantConcurrencyObserve{
    void tenantConcurrencyLevelChanged(StateMachineLevel to, StateMachineLevel from);
  }

  void sentence(Person person, StateType from, StateType to){



  }



}
