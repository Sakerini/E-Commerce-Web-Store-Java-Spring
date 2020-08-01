<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Shipping</h1>

            <p class="lead">Shipping Details:</p>
        </div>

        <form:form modelAttribute="order" class="form-horizontal">

        <h3>Shipping Address</h3>
        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber"
                        class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingCity">City Name</label>
            <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="shippingCountry">Country Name</label>
            <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">Zip Code</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>
        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Cancel</button>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected">
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>