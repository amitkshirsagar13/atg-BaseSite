<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<%@page import="java.io.*"%>
	<div class="container">
		<ul id="double" class="link-list">
			<%
				File rootContext = new File(this.getServletContext().getRealPath(""));

					File[] listFiles = rootContext.listFiles();
					int i = 0;
					for (File fileName : listFiles) {
						if (fileName.getName().endsWith("jsp")) {
							i++;
			%>
			<li><a href="./<%=fileName.getName()%>" class="arrow"> # <%=fileName.getName()%></a></li>
			<%
				} else {
							if (fileName.isDirectory()) {
								File[] directory = fileName.listFiles();
								for (File fileInName : directory) {
									if (fileInName.getName().endsWith("jsp")) {
										i++;
			%>
			<li><a
				href="./<%=fileName.getName()%>/<%=fileInName.getName()%>"
				class="arrow"> # <%=fileName.getName()%>/<%=fileInName.getName()%></a></li>
			<%
				}
								}
							}
						}
					}

					if (!(i % 2 == 0)) {
			%>
			<li><a href="#"></a>&nbsp;</li>
			<%
				}
			%>
		</ul><%=rootContext.getAbsolutePath()%>
	</div>
	<img src="/static-domain/resources/images/random.jpg" />
</dsp:page>