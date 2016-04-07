<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../subnav_admin.jsp" %>

<div class="wrapper">
    <div class="col-sm-12">
        <p class="page-header h4"><i class="fa fa-tag"></i> Elements</p>
    </div>

    <%--SIDEBAR--%>
    <%@ include file="element_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Element Type</th>
                    <th>Elements</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elementType" items="${elementTypeList}">
                    <tr>
                        <td>${elementType.id}</td>
                        <td>${elementType.elementTypeName}</td>
                        <td>Elements will go here</td>
                        <td><a href="/admin/element/edit/${elementType.id}"><i class="fa fa-pencil"></i> Edit</a></td>
                        <td><a href="/admin/element/delete/${elementType.id}"><i class="fa fa-trash"></i> Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>

</div>

<%@ include file="../../includes/footer.jsp" %>
