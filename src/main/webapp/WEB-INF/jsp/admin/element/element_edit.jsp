<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../subnav_admin.jsp" %>

<script>
    $(document).ready(function(){
        //attach an onclick function to the remove buttons
        $('.remove_btn').click(function() {
            //log name of button and contents of associated text box
            console.log(this.name);
            console.log($('#' + this.name).val());
            //clear the value / contents of the textbox
            $('#' + this.name).val('');
            //submit the form
            $('#elementType').submit();
        });
    });

</script>

<div class="wrapper">
    <div class="col-sm-12">
        <p class="page-header h4"><i class="fa fa-tag"></i> Elements</p>
    </div>
    <%--SIDEBAR--%>
    <%@ include file="element_sidebar.jsp" %>

    <%--SITE WRAPPER--%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <%--INITIALIZE COUNTER {idx}--%>
            <c:set var="idx" value="0" scope="page" />
            <%-- FORM {modelAttribute="elementType"} USED IN {AdminController.java} --%>
            <form:form cssClass="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />

                <%--INPUT FOR THE {elementTypeName}--%>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="inputElementTypeName">Element Type</label>
                        <div class="col-sm-9">
                            <%--THE PATH {path="elementTypeName}" FOR THIS INPUT LINKS TO THE POPERTY FOR THE {elementType} POJO --%>
                            <form:input path="elementTypeName" type="text" id="inputElementTypeName" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <%--HORIZONTAL RULE--%>
                <div class="row"><div class="col-sm-12"><hr/></div></div>

                <%--LISTS ALL THE {Elements} IN THE {elementList} FOR THE SELECTED {ElementType}--%>
                <%--THIS ITEMS {items="${elementType.elementList}"} LINK TO THE {elementList} IN THE {ElementType} POJO--%>
                <c:forEach items="${elementType.elementList}" var="element">
                    <%--THESE HIDDEN INPUTS ARE THE INDEX {${idx}} OF THE SELECTED ELEMENT LIST--%>
                    <form:hidden path="elementList[${idx}].id" />
                    <form:hidden path="elementList[${idx}].version" />
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="${idx}"><i class="fa fa-pencil"></i> Edit</label>
                            <div class="col-sm-9">
                                <div class="input-group">

                                    <%--THE PATH {path="elementList[${idx}].elementName"} LINKS TO THE ADMIN CONTROLLER--%>
                                    <%--JQUERY IS SELECTING THIS INPUT TO CLEAR USING THE INDEX {id="${idx}"}--%>
                                    <form:input path="elementList[${idx}].elementName" id="${idx}" cssClass="form-control" />

                                    <span class="input-group-btn">
                                        <button name="${idx}" class="btn btn-default remove_btn" type="button" ><i class="fa fa-trash"></i> Remove</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx + 1}" scope="page" />
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="inputNewElement"><i class="fa fa-plus-circle"></i> Add</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewElement" id="inputNewElement"/>
                        </div>

                    </div>
                </div>

                <div class="row"><div class="col-sm-12"><hr/></div></div>


                <div class="row">
                        <button class="btn btn-primary pull-right"><i class="fa fa-folder"></i> Update</button>
                </div>

            </form:form>

        </div>

        <%--ALERTS--%>
        <div class="col-sm-3">
            <%--SUCCESS ALERT--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Success!</h4>
                    <p>Well Done! <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <%--WARNING ALERT--%>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <%--DANGER ALERT--%>
            <div class="${dangerAlert == null ? 'hidden' : dangerAlert}" id="dangerAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Danger!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
        </div>

    </div>

</div>

<%@ include file="../../includes/footer.jsp" %>
