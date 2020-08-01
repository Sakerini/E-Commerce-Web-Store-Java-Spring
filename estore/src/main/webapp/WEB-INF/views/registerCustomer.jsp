<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Fill the below information to register:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" modelAttribute="customer" enctype="multipart/form-data">

        <h3>Basic Information</h3>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <form:input path="Username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Passoword</label>
            <form:password path="password" id="password" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>
        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="billingCity">City Name</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="billingCountry">Country Name</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingZip">Zip Code</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>
        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingCity">City Name</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingCountry">Country Name</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">Zip Code</label>
            <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>