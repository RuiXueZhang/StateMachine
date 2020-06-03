package stateMachine.Controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;


@Slf4j
public class RedissionLockTest {

    public static void testDistributeLock(String cid) throws InterruptedException{
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(0);
        RedissonClient redisson = Redisson.create(config);

        ecxecteLock(redisson,cid);
    }

    public static void ecxecteLock(RedissonClient redissonClient, String cid) throws InterruptedException {
        //可重入锁（Reentrant Lock）
        RLock lock = redissonClient.getLock("lock-"+cid);
        boolean locked = false;

        try {
            log.info("try lock");
            locked = lock.tryLock();
            log.info("locked result={}", locked);
            if (locked) {
                TimeUnit.HOURS.sleep(1);
                log.info("get Lock and finished");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            log.info("enter unlock");
            if(locked){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
       /* try {
            testDistributeLock("123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       /*ThreadLocal threadLocal = new ThreadLocal();
       threadLocal.set(10);
       System.out.println(threadLocal.get());*/


       Long pri =10L;
       long s =pri;
       System.out.println(s);

       /*Long q = null;
       if(q != null){
           System.out.println(10);
       }*/
    }
}
