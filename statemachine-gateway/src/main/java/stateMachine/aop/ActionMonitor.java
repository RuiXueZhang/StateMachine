package stateMachine.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActionMonitor {

    private static Logger logger = LoggerFactory.getLogger(ActionMonitor.class);
   /* @Around("")
    public Object aroundServiceAccess(ProceedingJoinPoint proceedingJoinPoint){
        return doLog(this, logger, proceedingJoinPoint);
    }

    public static Object doLog(Object aopObj, Logger logger,     proceedingJoinPoint){


        return null;
    }*/

    //匹配QueryPerson类中方法
    @Pointcut("within(cn.ruix.stateMachine.Controller.QueryPerson)")
    public void matchClass(){
        System.out.println("QueryPerson类中的方法正在执行。。。");//这个statement不会执行
    }

    //测试匹配class的方法
    @Before("matchClass()")
    public void doBeforeClassMatch(JoinPoint joinPoint){
        System.out.println("QueryPerson类下的方法:"+joinPoint+"将被执行");
    }


    //匹配cn.ruix.stateMachine包及子包下的所有方法
    @Pointcut("within(cn.ruix.stateMachine..*)")
    public void matchPackage(){
    }

    //测试匹配package的方法
    @Before("matchPackage()")
    public void doBeforePackageMatch(JoinPoint joinPoint){
        System.out.println("cn.ruix.stateMachine包及子包下的方法:"+joinPoint+"将被执行");
    }

    //匹配注解
    /*
      @annotation匹配方法级别
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void annotation(){
    }

    //测试方法级别匹配对应注解的方法
    @Before("annotation()")
    public void doAnnocationMatchFuncation(JoinPoint joinPoint){
        System.out.println("拥有注释RequestMapping的方法："+joinPoint+"被执行了");
    }

    /*
    匹配类级别
     */
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void annotationClass(){
    }

     @Before("annotationClass()")
    public void doAnnocationMatchClass(JoinPoint joinPoint){
        System.out.println("拥有注释@RestController的类："+joinPoint+"在被调用");
    }

    /**
     * @target 匹配类级别
     * 非 Spring环境下,要求的 annotation 的 RetentionPolicy 级别为 RUNTIME
     * 如下，匹配 标注有 @Service注解 的类 的所有方法
     */
    /*@Before("@target(org.springframework.stereotype.Component)")
    public void doTarget(JoinPoint joinPoint){
        System.out.println("注释的运行环境为runtime的类正在调用");
    }


    /**
     * @args 匹配参数级别
     * 如下，匹配 某方法的参数 所属的类 标注有 authority注解 的方法
     * 即，被拦截的方法的参数中，有的参数所属的类 标注有 authority注解
     */
/*
      @Pointcut("@args(org.springframework.stereotype.Component)")
      public void args(){
      }
      @Before("args()")
      public void doArgs(){
          System.out.println("正在执行的方法参数中被Component标注");
      }
*/
      /**execution()表达式
       * 结构:execution(<修饰符>?<返回值类型><方法>(<参数列表>)<异常>?)
       * ?为可选，其他未必选

      @Pointcut("execution(void cn.ruix.stateMachine.Controller.QueryPerson.* (..)")
       public void doExecution(){
          System.out.println("符合目标方法（返回值为void，方法为QueryPerson类下的方法，参数为任意参数）正在被执行");
      }*/

}
