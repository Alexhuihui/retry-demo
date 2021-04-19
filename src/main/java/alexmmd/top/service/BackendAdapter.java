package alexmmd.top.service;

/**
 * @author 汪永晖
 * @creatTime 2021/4/19 20:01
 */

import alexmmd.top.exception.RemoteServiceNotAvailableException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface BackendAdapter {

    @Retryable(value = {RemoteServiceNotAvailableException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback);

    @Recover
    public String getBackendResponseFallback(RuntimeException e);

    @Retryable(value = {RemoteServiceNotAvailableException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String getBackend(boolean simulateretry, boolean simulateretryfallback);

    @Recover
    public String getBackendFallback(RuntimeException e);

}
