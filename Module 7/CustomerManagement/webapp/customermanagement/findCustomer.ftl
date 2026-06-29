<#-- findCustomer.ftl -->
<div class="screenlet">
    <div class="screenlet-title-bar">
        <h3>Find Customer</h3>
    </div>
    <div class="screenlet-body">
        <form method="post" action="<@ofbizUrl>main</@ofbizUrl>" class="basic-form">
            <table class="basic-table" cellspacing="0">
                <tr>
                    <td class="label">Party ID</td>
                    <td><input type="text" name="partyId" value="${parameters.partyId!}"/></td>
                </tr>
                <tr>
                    <td class="label">Email Address</td>
                    <td><input type="text" name="emailAddress" value="${parameters.emailAddress!}"/></td>
                </tr>
                <tr>
                    <td class="label">First Name</td>
                    <td><input type="text" name="firstName" value="${parameters.firstName!}"/></td>
                </tr>
                <tr>
                    <td class="label">Last Name</td>
                    <td><input type="text" name="lastName" value="${parameters.lastName!}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search" class="smallSubmit"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<#if customerList?has_content>
<div class="screenlet">
    <div class="screenlet-title-bar">
        <h3>Search Results</h3>
    </div>
    <div class="screenlet-body">
        <table class="basic-table hover-bar" cellspacing="0">
            <tr class="header-row">
                <th>Party ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
            </tr>
            <#list customerList as customer>
            <tr>
                <td>${customer.partyId}</td>
                <td>${customer.firstName!}</td>
                <td>${customer.lastName!}</td>
                <td>${customer.infoString!}</td>
            </tr>
            </#list>
        </table>
    </div>
</div>
</#if>