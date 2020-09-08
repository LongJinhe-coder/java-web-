package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Log;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpLoad extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Map<String, String> m1 = new HashMap<String, String>();
		this.getServletContext().setAttribute("ipsno", m1);
	}

	public void destroy() {
		super.destroy();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡip��ַ
		String requestip = request.getRemoteAddr();
		// String requesthostName=request.getRemoteHost();
		//����·��
		String saveDirectory = this.getServletContext().getRealPath("")
				+ "\\upload";
		//�ļ�
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();//����һ��Ŀ¼
		}
		int maxPostSize = 3 * 5 * 1024 * 1024; // ���ϴ���С���ƣ�15M
		// FileRenamePolicy policy =(FileRenamePolicy)new
		// DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory,
				maxPostSize, "utf-8");

		Enumeration<String> files = multi.getFileNames();

		String name = files.nextElement();
		//��ȡ�ļ���
		File f = multi.getFile(name);
		if (f != null) {
			String message = "";
			String fileName = f.getName();
			//trim()ȥ��ǰ��ո�
			String sno = fileName.trim().substring(0, 8);
			Map<String, String> m1 = (Map<String, String>) this
					.getServletContext().getAttribute("ipsno");

			String msno1 = m1.get(requestip);
			Cookie[] cs = request.getCookies();
			String msno2 = null;
			if (cs != null) {
				for (int i = 0; i < cs.length; i++) {
					if (cs[i].getName().equals("sno")) {
						msno2 = cs[i].getValue();

					}
				}
				if (msno1 == null && msno2 == null) {// û�ϴ���
					m1.put(requestip, sno);

					Cookie c = new Cookie("sno", sno);
					c.setMaxAge(3 * 3600);
					response.addCookie(c);
					//����·��
					File sServerFile = new File(saveDirectory + "\\"
							+ requestip + "-" + fileName);
					if (sServerFile.exists()) {
						sServerFile.delete();
					}
					f.renameTo(sServerFile);
					message = "�ļ��ϴ��ɹ����ļ���Ϊ��" + fileName;

				} else if (msno1 != null && msno2 == null) {// �ø�ip����
					if (sno.equals(msno1)) {// �����������ش�
						Cookie c = new Cookie("sno", sno);
						c.setMaxAge(3 * 3600);
						response.addCookie(c);

						File sServerFile = new File(saveDirectory + "\\"
								+ requestip + "-" + fileName);
						if (sServerFile.exists()) {
							sServerFile.delete();
						}
						f.renameTo(sServerFile);
						message = "�ļ��ϴ��ɹ����ļ���Ϊ��" + fileName;
					} else {// �ø�ip��ѧ�Ŵ�
						f.delete();
						message = "ͬһ̨���������ϴ�����ѧ�ţ�������Ϣ���ϴ���";
						try {
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd kk:mm:ss ");
							sdf.setTimeZone(TimeZone
									.getTimeZone("Asia/Shanghai"));
							Log.writeLog(sdf.format(d) + ":" + requestip + "("
									+ msno1 + ")�ϴ�ѧ�ţ�" + sno);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (sno.equals(msno1) && sno.equals(msno2)) {
					File sServerFile = new File(saveDirectory + "\\"
							+ requestip + "-" + fileName);
					if (sServerFile.exists()) {
						sServerFile.delete();
					}
					f.renameTo(sServerFile);
					message = "�ļ��ϴ��ɹ����ļ���Ϊ��" + fileName;
				} else {
					f.delete();
					message = "ͬһ̨���������ϴ�����ѧ�ţ�������Ϣ���ϴ���";
					try {
						Date d = new Date();
						//ʱ���ʽ��
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd kk:mm:ss ");
						sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
						//д��һ����־
						Log.writeLog(sdf.format(d) + ":" + requestip + "("
								+ msno1 + ")�ϴ�ѧ�ţ�" + sno);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("message", message);
			}
			request.getRequestDispatcher("/upload.jsp").forward(request,
					response);
		}
	}
}