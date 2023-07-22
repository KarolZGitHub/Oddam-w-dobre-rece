<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<form:form method="post" action="/register" modelAttribute="user">
    <div class="form-group form-group--inline">
        <form:label path="name">Imię:</form:label>
        <form:input path="name" required="true"/>
    </div>
    <div class="form-group form-group--inline">
        <form:label path="surname">Nazwisko:</form:label>
        <form:input path="surname" required="true"/>
    </div>
    <div class="form-group form-group--inline">
        <form:label path="password">Hasło:</form:label>
        <form:password path="password" required="true"/>
    </div>
    <div class="form-group form-group--inline">
        <form:label path="confirmPassword">Powtórz hasło:</form:label>
        <form:password path="confirmPassword" required="true"/>
    </div>
    <div class="form-group form-group--inline">
        <form:label path="email">E-mail:</form:label>
        <form:input path="email" required="true"/>
    </div>
    <div class="form-group form-group--inline">
        <form:label path="phoneNumber">Number telefonu:</form:label>
        <form:input path="phoneNumber" required="true"/>
    </div>
    <div class="form-group form-group--buttons">
        <input type="submit" value="Zarejestruj">
    </div>
</form:form>
<%@include file="footer.jsp"%>