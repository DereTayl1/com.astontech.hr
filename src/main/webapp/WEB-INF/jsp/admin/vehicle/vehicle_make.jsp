<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../subnav_admin.jsp" %>

<script>
    $(document).ready(function(){

       $('#selectMakeBtn').click(function(){
         $('#vehicleVO').submit();
       });

    });
</script>

<div class="wrapper">
    <div class="col-sm-12">
        <p class="page-header h4"><i class="fa fa-truck"></i> Vehicles</p>
    </div>
    <%--SIDEBAR--%>
    <%@ include file="vehicle_sidebar.jsp" %>


        <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-10">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/make" method="post">
                <fieldset>
                    <legend></i> Select A Make</legend>

                    <div class="form-group">
                        <label class="col-lg-2 control-label"><strong class="h4">Vehicle Make:</strong></label>
                        <div class="col-md-8">
                            <%--SELECT DROW DOWN--%>
                            <select class="form-control">
                                <option>Toyota</option>
                                <option>Chevy</option>
                                <option>Ford</option>
                                <option>Nissan</option>
                                <option>Dodge</option>
                            </select>
                        </div>
                        <div id="selectMakeBtn" class="col-md-2">
                            <a class="btn btn-primary" href="#"><i class="fa fa-check"></i> Select Make</a>
                        </div>
                    </div>
                </fieldset>
                <hr/> <%--END OF SECTION--%>

                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Model</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Camry</td>
                                <td>4</td>
                                <td class="text-right"><a href="#"><i class="fa fa-list"></i> View List</a></td>
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