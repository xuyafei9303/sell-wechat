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
                <#--表单-->
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单ID</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>

                    <#list orderDtoPage.content as orderDto>
                    <tbody>
                    <tr>
                        <td>${orderDto.orderId}</td>
                        <td>${orderDto.buyerName}</td>
                        <td>${orderDto.buyerPhone}</td>
                        <td>${orderDto.buyerAddress}</td>
                        <td>${orderDto.orderAmount}</td>
                        <td>${orderDto.getOrderStatusEnum().message}</td>
                        <td>${orderDto.getPayStatusEnum().message}</td>
                        <td>${orderDto.createTime}</td>
                        <td><a href="/sell/seller/order/detail?orderId=${orderDto.orderId}">详情</a></td>
                        <td>
                            <#if orderDto.getOrderStatusEnum().message == "新订单">
                                <a href="/sell/seller/order/cancel?orderId=${orderDto.orderId}">取消</a>
                            </#if>

                        </td>
                    </tr>
                    </#list>

                        </tbody>
                        </table>
                    </div>

                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">

                        <#if current_page lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${current_page - 1}&size=4">上一页</a></li>
                        </#if>

                        <#list 1..orderDtoPage.getTotalPages() as index>
                            <#if current_page == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">#{index}</a></li>
                            </#if>
                        </#list>

                        <#if current_page gte orderDtoPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${current_page + 1}&size=#{size}">下一页</a></li>
                        </#if>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#--弹窗-->
                <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    提醒
                                </h4>
                            </div>
                            <div class="modal-body">
                                您有新的订单！
                            </div>
                            <div class="modal-footer">
                                <button onclick="javascript:document.getElementById('notice').onpause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                            </div>
                        </div>

                    </div>

                </div>

    <#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg">
</audio>

    <script src="https://cdn.bootcss.com/jquery/1.4.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    var websocket = null;
    if('WebSocket' in window) {
        websocket = new WebSocket('ws: //xyf.s1.natapp.cc/sell/webSocket');
    } else {
        alert('该浏览器不支持websocket！');
    }

    websocket.onopen = function (event) {
        console.log('建立连接');
    }

    websocket.onclose = function (event) {
        console.log('连接关闭');
    }

    websocket.onmessage = function (event) {
        console.log('收到消息:' + event.data);
        // 弹窗提醒播放音乐
        $('#myModal').modal('show');

        document.getElementById('notice').onplay();

    }

    websocket.onerror = function (event) {
        alert('websocket通信发生错误!');
    }

    window.onbeforeunload = function (event) {
        websocket.close();
    }

</script>
    </body>
</html>



