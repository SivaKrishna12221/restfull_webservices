<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
  <h1 style="color:green;text-align:center;">Add new Tourist</h1>
  <frm:form action="save_tourist" modelAttribute="tourist" method="POST">
  <table align="center">
   <tr><td>name</td><td><frm:input path="name"/></td></tr>
   <tr><td>place</td><td><frm:input path="place"/></td></tr>
  <tr><td>touristPackage</td><td><frm:input path="touristPackage"/></td></tr>
  <tr><td>budget</td><td><frm:input path="budget"/></td></tr>
  <tr><td><input type="submit" value="save"/></td><td><input type="reset" value="cancel"></td></tr>
  </table>
  </frm:form>
</html>