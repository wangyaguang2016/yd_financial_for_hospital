<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--以下是左侧NAV部分-->
<%--企业用户中心菜单 --%>
<div class="enterp_jliu left">
   	<ul id="ulMenu">
       	<li class="browerl"><a href="<%=path %>user/userCenterBSPage" style="color: #fa5b24">我的中心</a></li>
           <li class="browere"> 我的贷款 </li>
           	<ul class="myloan">
               	<li><a href="<%=path %>audit/auditListBSPage" class="browerr">贷款申请</a></li>
               	<li><a href="<%=path %>audit/auditListBSHisPage" class="browerr">历史记录</a></li>
               </ul><!--
               
               <li class="browere">我的账户</li>
           	<ul>
               	<li><a href="" class="browerr">基本信息维护</a></li>
               </ul>-->
               
               <li class="browere">安全中心</li>
           	<ul class="mysecurity">
               	<li><a href="<%=path %>user/realNamePage" class="browert">实名认证</a></li>
                   <li><a href="<%=path %>user/resetPwdPage" class="browery">密码修改</a></li>
               </ul>
          
       </ul>
</div>
<script>
	
var url = window.location;
var element = $('ul.ulmenu li a').filter(function() {
        return this.href == url.protocol + "//" + url.host + url.pathname ;
    }).parent().addClass('active');
    
</script>

