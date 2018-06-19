package com.kh.java.listener.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
//@WebListener
public class MySessionListener implements HttpSessionAttributeListener, HttpSessionListener {

    public MySessionListener() {
    }

    public void sessionCreated(HttpSessionEvent e)  { 
    	System.out.println(e.getSession().getId()+"가 생성 되었습니다.");
    }
    public void sessionDestroyed(HttpSessionEvent e)  {
    	System.out.println(e.getSession().getId()+"가 파괴 되었습니다.");
    }

    public void attributeAdded(HttpSessionBindingEvent e)  {
    	String name = (String)e.getSession().getAttribute("name");
    	System.out.println(name + "님이 접속하셧습니다.(리스너에서 출력)");
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    }
	
}
