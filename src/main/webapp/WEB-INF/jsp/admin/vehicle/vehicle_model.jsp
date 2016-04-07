<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../subnav_admin.jsp" %>

<div class="wrapper">
<%--SECTION TITLE--%>
    <div class="col-sm-12">
        <p class="page-header h4"><i class="fa fa-truck"></i> Vehicles</p>
    </div>
    <%--SIDEBAR--%>
    <%@ include file="vehicle_sidebar.jsp" %>
    <%--MAIN--%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-10">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/model" method="post">
                <fieldset>
                    <legend></i> Select A Model</legend>

                    <div class="form-group">
                        <label class="col-lg-2 control-label"><strong class="h4">Vehicle Model:</strong></label>
                        <div class="col-md-8">
                            <%--SELECT DROW DOWN--%>
                            <select class="form-control">
                                <option>Camry</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <a class="btn btn-primary" href="#"><i class="fa fa-check"></i> Select Model</a>
                        </div>
                    </div>
                </fieldset>
                <hr/> <%--END OF SECTION--%>

                <%--VEHICLE LIST TABLE--%>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>#ID</th>
                                <th>VIN</th>
                                <th>License Plate</th>
                                <th>Vehicle Color</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>JHMES15894S476390</td>
                                <td>THE-056</td>
                                <td>Blue</td>
                                <td class="text-right"><a href="#"><i class="fa fa-pencil"></i> Edit</a></td>
                                <td class="text-right"><a href="#"><i class="fa fa-trash"></i> Delete</a></td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-md-4">

                    </div>
                </div>


            </form:form>
        </div>
        <div class="col-sm-3">

        </div>
    </div>

</div>
<%@ include file="../../includes/footer.jsp" %>