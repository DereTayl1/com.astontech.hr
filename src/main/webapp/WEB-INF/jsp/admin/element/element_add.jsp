<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../subnav_admin.jsp" %>

<script>
    $(document).ready(function(){

        $('#successAlert').delay(5000).fadeOut(2000);
        $('#warningAlert').delay(5000).fadeOut(2000);

    });
</script>

<div class="wrapper">
    <div class="col-sm-12">
        <p class="page-header h4"><i class="fa fa-tag"></i> Elements</p>
    </div>
<%--SIDEBAR--%>
    <%@ include file="element_sidebar.jsp" %>


    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-9">
            <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post">
                <fieldset>
                    <legend><i class="fa fa-tag"></i> Element Management</legend>

                    <div class="form-group">
                        <label for="inputNewElementType" class="col-lg-2 control-label">Element Type</label>
                        <div class="col-lg-10">
                            <span class="help-block">Enter a new Element Type.</span>
                            <form:input path="newElementType" type="text" cssClass="form-control" id="inputNewElementType" placeholder="Element Type"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewElements" class="col-lg-2 control-label">Elements</label>
                        <div class="col-lg-10">
                            <span class="help-block">Enter each new Element on a new line.</span>
                            <form:textarea path="newElements" rows="3" cssClass="form-control" id="inputNewElements"></form:textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default" >Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <%--ALERTS--%>
        <div class="col-sm-3">
        <%--SUCCESS ALERT--%>
        <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4>Success!</h4>
                <p>Great Work! <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
            </div>
        </div>
        <%--WARNING ALERT--%>
        <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
            <div class="alert alert-dismissible alert-warning">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4>Form Helper</h4>
                <p>All fields required. Please enter an Element Type and Element <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
            </div>
        </div>
        <%--DANGER ALERT--%>
        <div class="${dangerAlert == null ? 'hidden' : dangerAlert}" id="dangerAlert">
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4>There was an Error!</h4>
                <p>What, No Good? <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
            </div>
        </div>
        </div>
    </div>
</div>



<%@ include file="../../includes/footer.jsp" %>