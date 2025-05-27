<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:page>
    <style type="text/css">
        td {
            border: 1px solid black;
        }
    </style>
    <div>
        <table>
            <thead>
            <tr>
                <th>Uticel ID</th>
                <th>Név</th>
                <th>Tipus</th>
                <th>Leiras</th>
                <th>Orszag</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${travels}" var="travel">
                <tr>
                    <td><c:out value="${travel.uticel_id}"/></td>
                    <td><c:out value="${travel.nev}"/></td>
                    <td><c:out value="${travel.tipus}"/></td>
                    <td><c:out value="${travel.leiras}"/></td>
                    <td><c:out value="${travel.orszag}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:page>
