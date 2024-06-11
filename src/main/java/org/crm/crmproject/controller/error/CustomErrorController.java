package org.crm.crmproject.controller.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/errorPage")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 400 :
                    return "errorPage/400";
                case 401 :
                    return "errorPage/401";
                case 403 :
                    return "errorPage/403";
                case 404 :
                    return "errorPage/404";
                case 405 :
                    return "errorPage/405";
                case 500 :
                    return "errorPage/500";
                case 501 :
                    return "errorPage/501";
                case 502 :
                    return "errorPage/502";
            }

//            if (statusCode == HttpStatus.BAD_REQUEST.value()) {
//                return "errorPage/400";
//            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
//                return "errorPage/401";
//            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
//                return "errorPage/403";
//            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "errorPage/404";
//            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
//                return "errorPage/405";
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "errorPage/500";
//            } else if (statusCode == HttpStatus.NOT_IMPLEMENTED.value()) {
//                return "errorPage/501";
//            } else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
//                return "errorPage/502";
//            }
        }
        return "error/errorPage";
    }

//    이는 더는 사용x 예전 버전 Spring Boot 에서 사용했었음
//    public String getErrorPath() {
//        return "/error";
//    }
//
//    @GetMapping("/test999")
//    public void test999() {
//        throw new CustomException("999 에러 테스트", 999);
//    }
//
//    @GetMapping("/test400")
//    public void test400() {
//        throw new CustomException("400 에러 테스트", 400);
//    }
//
//    @GetMapping("/test401")
//    public void test401() {
//        throw new CustomException("401 에러 테스트", 401);
//    }
//
//    @GetMapping("/test403")
//    public void test403() {
//        throw new CustomException("403 에러 테스트", 403);
//    }
//
//    @GetMapping("/test404")
//    public void test404() {
//        throw new CustomException("404 에러 테스트", 404);
//    }
//
//    @GetMapping("/test405")
//    public void test405() {
//        throw new CustomException("405 에러 테스트", 405);
//    }
//
//    @GetMapping("/test500")
//    public void test500() {
//        throw new CustomException("500 에러 테스트", 500);
//    }
//
//    @GetMapping("/test501")
//    public void test501() {
//        throw new CustomException("501 에러 테스트", 501);
//    }
//    @GetMapping("/test502")
//    public void test502() { throw new CustomException("502 에러 테스트", 502); }

    @ExceptionHandler(CustomException.class)
    public String handleCustomException(CustomException ex, HttpServletRequest request) {
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, ex.getStatusCode());
        return "forward:/error";
    }
}