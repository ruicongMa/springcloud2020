package com.mark.strategy;

import com.mark.delegate.source.MemberController;
import com.mark.delegate.source.OrderController;
import com.mark.delegate.source.SystemController;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Mark
 * @date 2020/5/12 12:23
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String url = req.getRequestURI();
        String mid = req.getParameter("mid");

        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (url.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        try {
            Object result = handler.getMethod().invoke(handler.getController(), mid);
            resp.getWriter().write(String.valueOf(result));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    // private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    //     String url = req.getRequestURI();
    //     String mid = req.getParameter("mid");
    //
    //     if ("getMemberById".equals(url)) {
    //         new MemberController().getMemberById(mid);
    //     } else if ("getOrderById".equals(url)) {
    //         new OrderController().getOrderById(mid);
    //     } else if ("logout".equals(url)) {
    //         new SystemController().logout();
    //     } else {
    //         resp.getWriter().write("404 Not Found");
    //     }
    // }

    @Override
    public void init() throws ServletException {
        try {
            Class<MemberController> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.newInstance())
                    .setUrl("/web/getMethodById.json")
                    .setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class})));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    @Accessors(chain = true)
    class Handler {
        private Object controller;
        private Method method;
        private String url;
    }
}
