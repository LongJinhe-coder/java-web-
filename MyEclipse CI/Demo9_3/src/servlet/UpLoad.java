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
		//获取ip地址
		String requestip = request.getRemoteAddr();
		// String requesthostName=request.getRemoteHost();
		//保存路径
		String saveDirectory = this.getServletContext().getRealPath("")
				+ "\\upload";
		//文件
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();//创建一个目录
		}
		int maxPostSize = 3 * 5 * 1024 * 1024; // 总上传大小限制：15M
		// FileRenamePolicy policy =(FileRenamePolicy)new
		// DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory,
				maxPostSize, "utf-8");

		Enumeration<String> files = multi.getFileNames();

		String name = files.nextElement();
		//获取文件名
		File f = multi.getFile(name);
		if (f != null) {
			String message = "";
			String fileName = f.getName();
			//trim()去掉前后空格
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
				if (msno1 == null && msno2 == null) {// 没上传过
					m1.put(requestip, sno);

					Cookie c = new Cookie("sno", sno);
					c.setMaxAge(3 * 3600);
					response.addCookie(c);
					//保存路径
					File sServerFile = new File(saveDirectory + "\\"
							+ requestip + "-" + fileName);
					if (sServerFile.exists()) {
						sServerFile.delete();
					}
					f.renameTo(sServerFile);
					message = "文件上传成功！文件名为：" + fileName;

				} else if (msno1 != null && msno2 == null) {// 用该ip传过
					if (sno.equals(msno1)) {// 死机，开机重传
						Cookie c = new Cookie("sno", sno);
						c.setMaxAge(3 * 3600);
						response.addCookie(c);

						File sServerFile = new File(saveDirectory + "\\"
								+ requestip + "-" + fileName);
						if (sServerFile.exists()) {
							sServerFile.delete();
						}
						f.renameTo(sServerFile);
						message = "文件上传成功！文件名为：" + fileName;
					} else {// 用该ip换学号传
						f.delete();
						message = "同一台机器不能上传两个学号，作弊信息已上传！";
						try {
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd kk:mm:ss ");
							sdf.setTimeZone(TimeZone
									.getTimeZone("Asia/Shanghai"));
							Log.writeLog(sdf.format(d) + ":" + requestip + "("
									+ msno1 + ")上传学号：" + sno);
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
					message = "文件上传成功！文件名为：" + fileName;
				} else {
					f.delete();
					message = "同一台机器不能上传两个学号，作弊信息已上传！";
					try {
						Date d = new Date();
						//时间格式化
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd kk:mm:ss ");
						sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
						//写入一个日志
						Log.writeLog(sdf.format(d) + ":" + requestip + "("
								+ msno1 + ")上传学号：" + sno);
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