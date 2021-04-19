package alexmmd.top.service.impl;

import alexmmd.top.exception.RemoteServiceNotAvailableException;
import alexmmd.top.service.BackendAdapter;

/**
 * @author 汪永晖
 * @creatTime 2021/4/19 20:02
 */
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BackendAdapterImpl implements BackendAdapter {

    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) {

        if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenario.");

            if (simulateretryfallback) {
                throw new RemoteServiceNotAvailableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }

        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendResponseFallback(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }

    @Override
    public String getBackend(boolean simulateretry, boolean simulateretryfallback) {
        if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenario.");

            if (simulateretryfallback) {
                throw new RemoteServiceNotAvailableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }

        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendFallback(RuntimeException e) {
        System.out.println("所有重试机会都失败了");
        return "所有重试机会都失败了";
    }
}
