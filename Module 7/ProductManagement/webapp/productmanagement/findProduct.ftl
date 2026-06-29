<#-- findProduct.ftl -->
<div class="screenlet">
    <div class="screenlet-title-bar">
        <h3>Find Product</h3>
    </div>
    <div class="screenlet-body">
        <form method="post" action="<@ofbizUrl>main</@ofbizUrl>" class="basic-form">
            <table class="basic-table" cellspacing="0">
                <tr>
                    <td class="label">Product ID</td>
                    <td><input type="text" name="productId" value="${parameters.productId!}"/></td>
                </tr>
                <tr>
                    <td class="label">Product Name</td>
                    <td><input type="text" name="internalName" value="${parameters.internalName!}"/></td>
                </tr>
                <tr>
                    <td class="label">Category ID</td>
                    <td><input type="text" name="productCategoryId" value="${parameters.productCategoryId!}"/></td>
                </tr>
                <tr>
                    <td class="label">Price Range</td>
                    <td>
                        Min: <input type="text" name="minPrice" size="5" value="${parameters.minPrice!}"/> 
                        Max: <input type="text" name="maxPrice" size="5" value="${parameters.maxPrice!}"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search" class="smallSubmit"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<#if productList?has_content>
<div class="screenlet">
    <div class="screenlet-title-bar">
        <h3>Search Results</h3>
    </div>
    <div class="screenlet-body">
        <table class="basic-table hover-bar" cellspacing="0">
            <tr class="header-row">
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Price</th>
            </tr>
            <#list productList as product>
            <tr>
                <td>${product.productId}</td>
                <td>${product.internalName!}</td>
                <td>${product.categoryName!}</td>
                <td>${product.price!}</td>
            </tr>
            </#list>
        </table>
    </div>
</div>
</#if>