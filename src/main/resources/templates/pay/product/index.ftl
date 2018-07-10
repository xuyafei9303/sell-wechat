<html>
    <#include "../common/header.ftl">

<body>
<#--边栏-->
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
        <#include "../common/nav.ftl">
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" class="form-control" type="text" value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格 </label>
                            <input name="productPrice" class="form-control" type="text" value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" class="form-control" type="number" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" class="form-control" type="text" value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img width="200" height="150" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" class="form-control" type="text" id="exampleInputEmail1" value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                        <#--如果productInfo.categoryType存在并且productInfo.categoryType == category.categoryType-->
                                            <#if (productInfo.categoryType) ?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                                >
                                        ${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>



