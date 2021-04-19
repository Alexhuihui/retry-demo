package alexmmd.top.controller;

/**
 * @author 汪永晖
 * @creatTime 2021/4/19 19:59
 */

import alexmmd.top.service.BackendAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyRestController {

    @Resource
    BackendAdapter backendAdapter;

    @GetMapping("/retry")
    @ExceptionHandler({Exception.class})
    public String validateSPringRetryCapability(@RequestParam(required = false) boolean simulateretry,
                                                @RequestParam(required = false) boolean simulateretryfallback) {
        System.out.println("===============================");
        System.out.println("Inside RestController mathod..");

        return backendAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }

    @GetMapping("/retry2")
    @ExceptionHandler({Exception.class})
    public String validateSPringRetryCapability2(@RequestParam(required = false) boolean simulateretry,
                                                 @RequestParam(required = false) boolean simulateretryfallback) {
        System.out.println("===============================");
        System.out.println("进入接口..");

        return backendAdapter.getBackend(simulateretry, simulateretryfallback);
    }
}
