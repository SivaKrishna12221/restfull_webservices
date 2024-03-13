
<%@ page isElignored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
  <h1 style="color:green;text-align:center;">Tourist edit details</h1>
   <table align="center">
  <frm:form action="save_tourist" modelAttribute="tourist" method="POST">
  <tr><td>tid</td><td><frm:input path="tid" readOnly="true"/></td></tr>
 <tr><td>name</td><td><frm:input path="name"/></td></tr>
 <tr><td>place</td><td><frm:input path="place"/></td></tr>
 <tr><td>touristPackage</td><td><frm:input path="touristPackage" /></td></tr>
 <tr><td>budget</td><td><frm:input path="budget" /></td></tr>
 <tr><td><input type="submit" value="update"/></td><td><input type="reset" value="cancel"/></td></tr>
 </frm:form>
  </table>
  </div>
</html>