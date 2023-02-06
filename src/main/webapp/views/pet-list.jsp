<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Pets</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: pet;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <h2>Pets</h2>
        <table>
            <thead>
                <tr>
                    <td colspan="7"><a href="pet/add-new" style="float:right"><button>Add New Pet</button></a></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Experience (Years)</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pets}" var="pet">
                <tr>
                    <td>${pet.petId}</td>
                    <td>${pet.petName}</td>
                    <td>${pet.petAge}</td>
                    <td>${pet.petGender}</td>
                    <td>${pet.petBreed}</td>
                    <td>${pet.petStatus}</td>
                    <td>
                        <a href="/petanimal/${pet.petId}"><button>View</button></a>
                        <a href="/petanimal/edit-pet/${pet.petId}"><button>Edit</button></a>
                        <a href="/petanimal/delete/${pet.petId}"><button>Delete</button></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="7">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>