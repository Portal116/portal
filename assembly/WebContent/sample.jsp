<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="javax.xml.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="org.w3c.dom.*"%>
<%
URL url = null;
URLConnection urlConnection = null;

String stringUrl = "https://infuser.odcloud.kr/api/stages/36147/api-docs?1637651309380";
InputStream is = null;
String data = "";

try {

	url = new URL(stringUrl);
	urlConnection = url.openConnection();
	urlConnection.setDoOutput(true);

	is = urlConnection.getInputStream();

	byte[] buf = new byte[2048];
	int len = -1
	StringBuffer sb = new StringBuffer();

	while ((len = is.read(buf, 0, buf.length)) != -1) {
		sb.append(new String(buf, 0, len));
	}

	data = sb.toString();

} catch (MalformedURLException e) {
	e.getMessage();
} catch (IOException e) {
	e.getMessage();
} finally {
	if (is != null) {
		is.close();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	java sample page
	<%=data%>;
</body>
</html>