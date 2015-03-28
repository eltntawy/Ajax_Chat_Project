<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>

    <script type="application/javascript" >

        var messageId = -1;

        function sendMessage(e) {
            var ret;
            if( e != null && e.keyCode == 13 && $("#sendMessage").val() != '' ) {
                var data = {username : $("#userId").val(), message : $("#sendMessage").val()};
                $.post("${pageContext.request.contextPath}/chat/ChatServlet",data,ret);
                $("#sendMessage").val('') ;
            } else if( e == null && $("#sendMessage").val() != '') {
                var data = {username : $("#userId").val(), message : $("#sendMessage").val()};
                $.post("${pageContext.request.contextPath}/chat/ChatServlet",data,ret);
                $("#sendMessage").val('') ;
            }

            receiveMessages();
        }


        function receiveMessages() {
            var ret;

            $.get("${pageContext.request.contextPath}/chat/ChatServlet?messageId="+messageId,appendMessage);
        }

        function appendMessage (responseText,statusTxt, xhr ) {

            if(responseText.length > 0) {
                $("#chat-box").append(responseText);

                var messages = $("#chat-box").children();

                messageId = messages[messages.length -1].id;
            }
        }

        setInterval(function () {
            receiveMessages()
        },5000);

    </script>





    <meta charset="UTF-8">
    <title>ChatService | Chat Room</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- FontAwesome 4.3.0 -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="${pageContext.request.contextPath}/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- Date Picker -->
    <link href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-page" id="body">


<div class="register-box span11">
    <div class="register-logo">
        <a href="${pageContext.request.contextPath}"><b>Chat</b>Service</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg"> Have fun with our chat service</p>

<div >


    <div class="item">
        <p class="message">
            <a href="#" class="name">
                <small class="text-muted pull-right"><i class="fa fa-clock-o"></i><c:out value="${Date}" /></small>
                User name : ${user.fullName}
                <input id="userId" type="hidden" value="${user.id}"/>
            </a>
        </p>

    </div><!-- /.item -->



    <!-- Content Wrapper. Contains page content -->
    <div >
        <!-- Content Header (Page header) -->
        <!-- Chat box -->
        <div class="box box-success" style="height: 100%" >
            <div class="box-header">
                <i class="fa fa-comments-o"></i>
                <h3 class="box-title">Chat</h3>
                <%--<div class="box-tools pull-right" data-toggle="tooltip" title="Status">--%>
                    <%--<div class="btn-group" data-toggle="btn-toggle" >--%>
                        <%--<button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-green"></i></button>--%>
                        <%--<button type="button" class="btn btn-default btn-sm"><i class="fa fa-square text-red"></i></button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
            <div class="box-body chat" id="chat-box">


                <!-- chat item
                <div class="item">
                  <img src="${pageContext.request.contextPath}/dist/img/user4-128x128.jpg" alt="user image" class="online"/>
                  <p class="message">
                    <a href="#" class="name">
                      <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> 2:15</small>
                      Name
                    </a>
                    Message
                  </p>

                </div><!-- /.item -->

            </div><!-- /.chat -->


            <div class="box-footer">
                <div class="input-group">
                    <input class="form-control" placeholder="Type message..."  id="sendMessage"
                           onkeypress="return sendMessage(event);" />
                    <div class="input-group-btn">
                        <button class="btn btn-success" onclick="sendMessage();" ><i class="fa fa-plus"></i></button>
                    </div>
                </div>
            </div>
        </div><!-- /.box (chat box) -->


    </div><!-- /.content-wrapper -->
</div>
    </div>
</div>
    <!-- jQuery 2.1.3 -->
    <script src="${pageContext.request.contextPath}/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- Morris.js charts -->
    <script src="/http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='${pageContext.request.contextPath}/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/dist/js/app.min.js" type="text/javascript"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="${pageContext.request.contextPath}/dist/js/pages/dashboard.js" type="text/javascript"></script>

    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/dist/js/demo.js" type="text/javascript"></script>
</body>
</html>