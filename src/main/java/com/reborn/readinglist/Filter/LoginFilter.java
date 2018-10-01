package com.reborn.readinglist.Filter;

import com.reborn.readinglist.Entity.Reader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private static String[] includeUrls = new String[]{"/index", "/reader/loginaction", "/true.jpg", "/css/jq22.css"};//不需要登录即可访问的页面

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        HttpServletResponse response1 = (HttpServletResponse)response;

        String url = request1.getRequestURI();
        System.out.println("fileter url:"+url);

        if(checkUrlNeedFilter(url)) {
            HttpSession session = request1.getSession(false);
//            Reader reader = session.getAttribute("reader")==null ? null : (Reader) session.getAttribute("reader");
            if(url.equals("/reader/login")) {
                if(session != null && session.getAttribute("reader") != null) {
                    System.out.println("已经登录过了"+session.getAttribute("reader"));
                    response1.sendRedirect(request1.getContextPath() + "/readingList/" + ((Reader)session.getAttribute("reader")).getUsername());
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                String requestType = request1.getHeader("X-Requested-With");
                //判断是否是ajax请求（因为ajax页面不跳转，所以这块需要判断一下）
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write("你还未登录");
                }else{
                    chain.doFilter(request, response);
                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response1.sendRedirect(request1.getContextPath()+"/reader/login");
                }
//                return;
            }

        } else {
            //不需要过滤
            chain.doFilter(request, response);
        }

    }

    private static boolean checkUrlNeedFilter(String url) {
        for (String includeUrl: includeUrls) {
            if(includeUrl.equals(url)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
