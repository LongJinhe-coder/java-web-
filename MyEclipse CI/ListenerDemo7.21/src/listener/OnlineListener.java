package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener {
	//��ʼ��һ��������onlineCount
	private static int onlineCount = 0;
	
	
	//��������
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		onlineCount += 1;
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		if (onlineCount>0) {
			onlineCount -= 1;
		}else {
			onlineCount = 0;
		}
	}

	public static int getOnlineCount() {
		return onlineCount;
	}

	public static void setOnlineCount(int onlineCount) {
		OnlineListener.onlineCount = onlineCount;
	}
	
	
}
