package com.lim.action;

import java.io.PrintWriter;

import com.lim.base.ActionBase;

public class AjaxAction  extends ActionBase{
	public void longPolling() throws Exception{
	    System.out.println("-----CometAction.longPolling.start");
	    PrintWriter writer = response.getWriter();
	    Thread longThread = new Thread() {
	        public void run() {
	            try {
	                //这里模拟全局事件监听，如果其他模块有需要发送消息就发送一个事件，然后休眠停止，发送消息。
	                sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        };
	    };
	    longThread.run();
	    writer.print("your hava a new message");
	    writer.flush();
	    writer.close();
	    System.out.println("-----CometAction.longPolling.end");
	}
}
