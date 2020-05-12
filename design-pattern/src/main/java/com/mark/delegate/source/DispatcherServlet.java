package com.mark.delegate.source;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2020/5/12 12:23
 */
public class DispatcherServlet extends HttpServlet {

    private Map<String, Method> handlerMapping = new HashMap<String, Method>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        Method method = handlerMapping.get(url);
        // method.invoke();
    }

    @Override
    public void init() throws ServletException {
        try {
            handlerMapping.put("/web/getMemberById.json", MemberController.class.getMethod("getMemberById", new Class[]{String.class}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
