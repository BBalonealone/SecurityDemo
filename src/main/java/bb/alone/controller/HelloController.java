package bb.alone.controller;


import bb.alone.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public Result<String> hello(){
        //加入全局异常捕获，不需要try-catch
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            log.info("获取当前认证用户的用户名为：{}",auth.getName());
            log.info("记录当前认证用户的认证权限：{}",auth.getAuthorities());
        }
        return Result.success("Hello World");
    }
}
